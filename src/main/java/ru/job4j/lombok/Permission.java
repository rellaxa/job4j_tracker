package ru.job4j.lombok;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
public class Permission {

    private int id;

    private String name;

    @Singular("rules")
    private List<String> rules;

    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("HIGH")
                .rules("Cook")
                .rules("BJ")
                .rules("Repeat")
                .build();
        System.out.println(permission);
    }
}
