package com.java.saif.DemoProject.service.applicationUser;

import com.java.saif.DemoProject.exception.UserNotFoundException;
import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUser;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUserResponse;
import com.java.saif.DemoProject.models.applicationUser.CreateApplicationUserRequest;
import com.java.saif.DemoProject.models.user.User;
import com.java.saif.DemoProject.repository.application.ApplicationRepository;
import com.java.saif.DemoProject.repository.applicationUser.ApplicationUserRepository;
import com.java.saif.DemoProject.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public ApplicationUserResponse createApplicationUser(CreateApplicationUserRequest createApplicationUserRequest) throws UserNotFoundException {
        User user = userRepository.getUserByEmail(createApplicationUserRequest.getUserEmail());
        if (user == null) {
            throw new UserNotFoundException("User with this Email Not found " + createApplicationUserRequest.getUserEmail());
        }
        Application application = applicationRepository.getApplicationByName(createApplicationUserRequest.getApplicationName());
        if (application == null) {
            throw new IllegalArgumentException("Application not found with name: " + createApplicationUserRequest.getApplicationName());
        }
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUser(user);
        applicationUser.setApplication(application);
        ApplicationUser createApplicationUser = applicationUserRepository.createApplicationUser(applicationUser);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ApplicationUserResponse applicationUserResponse = mapper.map(createApplicationUser, ApplicationUserResponse.class);
        return applicationUserResponse;
        //Go through this concept ModelMapper
    }

    @Override
    public void deleteApplicationUserById(Long applicationUserId) {
        applicationUserRepository.deleteApplicationUserById(applicationUserId);
    }

    @Override
    public List<Application> listApplicationsForUser(String userEmail) {
        return applicationUserRepository.listApplicationsForUser(userEmail);
    }
}