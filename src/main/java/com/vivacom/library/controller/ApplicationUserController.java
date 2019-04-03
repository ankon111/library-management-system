package com.vivacom.library.controller;

import com.vivacom.library.constants.ConstantValues;
import com.vivacom.library.model.dto.SuccessResponse;
import com.vivacom.library.model.entity.ApplicationUser;
import com.vivacom.library.service.user.IApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Ankon on 10/17/2017.
 */
@RestController
@RequestMapping("/api/v1")
public class ApplicationUserController {

    @Autowired
    private IApplicationUserService iApplicationUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MessageSource messageSource;



    @RequestMapping(value = "/login-success", method = RequestMethod.POST)
    public ResponseEntity login(HttpServletResponse response) {
        String token = "";



        return ResponseEntity.ok().header(ConstantValues.HEADER_STRING, ConstantValues.TOKEN_PREFIX + " " + token).build();
    }


    /**
     * This method is used for Registration/ Sign-up
     *
     * @param applicationUser
     * @return
     */
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse signUp(@RequestBody @Valid ApplicationUser applicationUser) {
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        iApplicationUserService.insertUser(applicationUser);

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setMessage( messageSource.getMessage("user.signup.success", null, null));

        return successResponse;
    }


    /*private void authenticate(String userName, String password) {
        ApplicationUser applicationUser = iApplicationUserService.getApplicationUserByUserName(userName);
        if (applicationUser == null) {
            throw new SecurityException();
        }

        if (!bCryptPasswordEncoder.matches(password, applicationUser.getPassword())) {
            throw new SecurityException();
        }
    }*/

}
