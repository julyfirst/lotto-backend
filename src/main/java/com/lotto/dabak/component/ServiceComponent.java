package com.lotto.dabak.component;


import com.lotto.dabak.service.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ServiceComponent {

    @Autowired
    private NumberService numberService;


}
