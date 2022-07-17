package com.wipro.DoConnect.services.admin;

import java.util.List;

import com.wipro.DoConnect.dto.*;
import com.wipro.DoConnect.responce.GeneralResponse;

public interface AdminService {

    void createAdminAccount();

    UserDto createAdmin(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);

    GeneralResponse login(AuthenticationRequest authenticationRequest);

    List<QuestionDto> getAllQuestions();

    GeneralResponse approveAnswer(Long id);

    GeneralResponse approveQuestion(Long id);

    public void deleteQuestion(Long id);

    public void deleteAnswer(Long id);

    List<AnswerDto> getAllAnswers();
}
