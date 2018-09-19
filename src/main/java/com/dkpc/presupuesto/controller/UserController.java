package com.dkpc.presupuesto.controller;

import com.dkpc.presupuesto.exception.ResourceNotFoundException;
import com.dkpc.presupuesto.model.User;
import com.dkpc.presupuesto.payload.UserIdentityAvailability;
import com.dkpc.presupuesto.payload.UserProfile;
import com.dkpc.presupuesto.payload.UserSummary;
import com.dkpc.presupuesto.repository.ProjectRepository;
import com.dkpc.presupuesto.repository.UserRepository;
import com.dkpc.presupuesto.security.CurrentUser;
import com.dkpc.presupuesto.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        long projectCount = projectRepository.countByCreatedby(user.getId());

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(), projectCount);

        return userProfile;
    }

    // Find all devices method
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() throws IOException {

        //ReadCsvFile deviceIds = new ReadCsvFile();
        //String[] test = deviceIds.ReadCsvFile();

        return this.userRepository.findAll();
    }


}
