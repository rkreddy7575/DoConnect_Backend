package com.wipro.DoConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.wipro.DoConnect.dto.AnswerDto;
import com.wipro.DoConnect.dto.QuestionDto;
import com.wipro.DoConnect.responce.GeneralResponse;
import com.wipro.DoConnect.services.questions.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionsController {


    @Autowired
    private QuestionService questionService;



    @PostMapping("")
    public GeneralResponse addQuestion(@RequestBody QuestionDto questionDto) {
        GeneralResponse response = new GeneralResponse();
        try {
            String serviceRes = questionService.addQuestion(questionDto);
            response.setStatus(serviceRes.equals("User Not Found") ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.CREATED);
            response.setMessage(serviceRes);
            return response;
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
        }
    }

    @GetMapping("all")
    public GeneralResponse getAllQuestion() {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(questionService.getAllQuestions());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Questions Fetched Successfully!!!");
            return response;
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
        }
    }

    @GetMapping("{id}/{userId}")
    public GeneralResponse getQuestionById(@PathVariable Long id, @PathVariable Long userId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(questionService.getQuestionById(id,userId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Questions Fetched Successfully!!!");
            return response;
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
        }
    }

    @GetMapping("/search/{pageNum}/{title}")
    public GeneralResponse searchQuestionByTitle(@PathVariable("title") String title, @PathVariable("pageNum") int pageNum) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(questionService.searchQuestionByTitle(title,pageNum));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Questions Fetched Successfully!!!");
            return response;
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;

        }
    }

    @PostMapping("addAnswer")
    public GeneralResponse addAnswer(@ModelAttribute AnswerDto answerDto) {
        GeneralResponse response = new GeneralResponse();
        try {
            return questionService.addAnswer(answerDto);
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
        }
    }


}
