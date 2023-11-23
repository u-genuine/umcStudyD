package umc.study.domain.Member.entity;

public enum Level {

    MANAGER("관리자"),
    USER("사용자");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return name.equals("관리자");
    }
}