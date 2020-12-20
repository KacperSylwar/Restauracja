package pl.sylwar.Restauracja.model;

public class Dish {
    private Long id;
    private String name;
    private String description;
    private Boolean ordered;
    private Long categoryId;
    private Integer price;

    public Dish(Long id, String name, String description, Boolean ordered, Long categoryId, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ordered = ordered;
        this.categoryId = categoryId;
        this.price = price;
    }

    public String getDetailsUrl(){
        return "/dish/" + name;
    }

    public String getUrl(){return "/img/" + name + ".jpg";}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


}
/*
<form th:action="@{/auto/{name}/createComment(name=${auto.getName()})}" th:object="${comment}" method="post">
                <input type="text" th:field="*{userName}" placeholder="User name">
                <input type="text" th:field="*{tekst}" placeholder="Type comment here">
<!--                <input type="text" th:field="*{autoId}" th:value="${auto.id}">-->

                <input class="btn btn-warning" type="submit" value="Add comment">
            </form>
 */
