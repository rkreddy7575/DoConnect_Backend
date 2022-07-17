package com.wipro.DoConnect.services.questions;


import java.util.List;

import com.wipro.DoConnect.dto.AnswerDto;
import com.wipro.DoConnect.dto.QuestionDto;
import com.wipro.DoConnect.dto.QuestionSearchResponceDto;
import com.wipro.DoConnect.dto.SingleQuestionDto;
import com.wipro.DoConnect.responce.GeneralResponse;

public interface QuestionService {

    String addQuestion( QuestionDto questionDto);

    List<QuestionDto> getAllQuestions();

    SingleQuestionDto getQuestionById(Long id, Long userId);

    QuestionSearchResponceDto searchQuestionByTitle(String title, int pageNum);

    GeneralResponse addAnswer(AnswerDto answerDto);

}
