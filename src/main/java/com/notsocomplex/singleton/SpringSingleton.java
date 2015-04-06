package com.notsocomplex.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
@Component
public class SpringSingleton {
}