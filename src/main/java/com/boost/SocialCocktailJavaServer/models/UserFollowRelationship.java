package com.boost.SocialCocktailJavaServer.models;

import javax.persistence.*;

@Entity
public class UserFollowRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User follower;

    @ManyToOne
    private User followed;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }
}
