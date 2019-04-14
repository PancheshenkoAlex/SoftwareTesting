package ru.stqa.pft.addressbook.model;

import org.testng.annotations.Test;

import java.util.Objects;

public class GroupData {
    private int id;
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.id = 0;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public GroupData(int id, String groupName, String groupHeader, String groupFooter) {
        this.id = id;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public int getId() { return id; }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public void setID(int id) { this.id = id; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }


}
