package com.boost.SocialCocktailJavaServer.models;

public class JacksonView {
    interface freeContext {}
    interface withCommentContext {}
    interface withCocktailContext {}
    interface withUserContext {}

    public interface forCommentRequest extends freeContext, withCocktailContext, withUserContext {}
    public interface forCocktailRequest extends freeContext, withCommentContext, withUserContext {}
    public interface forUserRequest extends freeContext, withCocktailContext, withCommentContext {}
}
