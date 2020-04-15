package com.cv.mycar.service.iml;

import com.alibaba.dubbo.config.annotation.Service;
import com.cv.mycar.dao.mapper.UsersMapper;
import com.cv.mycar.dao.model.Users;
import com.cv.mycar.dto.UserDto;
import com.cv.mycar.service.IUserService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author shimengqiang
 * @Date 2020-04-14-16:54
 * @Version 1.0
 */
@Service(timeout = 10000)
@Component
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UsersMapper usersMapper;
    @PostConstruct
    public void test(){
        System.out.println(usersMapper.selectAll().toString());
    }

    private static ExecutorService executorService;
    static {
        executorService = new ThreadPoolExecutor(10, 50,
                10L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryBuilder().setNameFormat("User_Async_FutureTask-%d").setDaemon(true).build(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    @Override
    public List<UserDto> findAll() {
        int totalCount = usersMapper.count();
        int offset = 10;
        List<Callable<List<Users>>> callables = new ArrayList<>();
        for (int i = 0; i < totalCount; i = i+offset) {
            int finalI = i;
            Callable<List<Users>> callable = () -> usersMapper.pageQuery(finalI, offset);
            callables.add(callable);
        }
        List<Future<List<Users>>> futures = new ArrayList<>();
        try {
            futures = executorService.invokeAll(callables,10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Users> usersList = new ArrayList<>();
        for (Future<List<Users>> future : futures) {
            try {
                List<Users> users = future.get();
                System.out.println(Thread.currentThread().getName() + " ===== "+users.toString());
                usersList.addAll(users);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (CancellationException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        List<UserDto> dtoList = new ArrayList<>();
        usersList.forEach(user->{
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            dtoList.add(userDto);
        });
        return dtoList;
    }
}
    