package com.viniciusmope.museumchatbot.controllers;

import com.viniciusmope.museumchatbot.dto.MessageRequest;
import com.viniciusmope.museumchatbot.dto.MessageResponse;
import com.viniciusmope.museumchatbot.services.FaqService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class FaqController {
    final private FaqService faqService;

    public FaqController(FaqService faqService){
        this.faqService = faqService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> answerQuestion(@RequestBody MessageRequest request){
        String answer = this.faqService.getAnswer(request.message());
        MessageResponse response = new MessageResponse(answer);
        return ResponseEntity.ok(response);
    }
}
