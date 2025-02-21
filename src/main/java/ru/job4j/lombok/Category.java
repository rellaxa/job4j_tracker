package ru.job4j.lombok;

import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @Getter
    @NonNull
    @EqualsAndHashCode.Include
    private int id;

    @Getter
    @Setter
    private String name;

    public static void main(String[] args) {
        var category = new Category(1);
        System.out.println(category.hashCode());
    }
}
