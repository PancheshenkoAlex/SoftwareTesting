package ru.stqa.pft.addressbook;

public class PersonalData {
    private final String name;
    private final String middleName;
    private final String lstName;
    private final String nickName;

    public PersonalData(String name, String middleName, String lstName, String nickName) {
        this.name = name;
        this.middleName = middleName;
        this.lstName = lstName;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLstName() {
        return lstName;
    }

    public String getNickName() {
        return nickName;
    }
}
