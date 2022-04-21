package fr.tradisson.account.manager.model;

import java.util.List;

public class Account {
  
  private String name;
  private String comment;

  // To store as comma-separated
  private List<String> users;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public List<String> getUsers() {
    return users;
  }

  public void setUsers(List<String> users) {
    this.users = users;
  }

}
