package com.bncrypted.authenticator.checker.core.user;

import com.bncrypted.authenticator.checker.core.SubjectResolver;
import com.bncrypted.authenticator.checker.core.model.User;
import com.bncrypted.authenticator.parser.core.model.UserTokenDetails;
import com.bncrypted.authenticator.parser.core.user.UserTokenParser;

public class UserResolver implements SubjectResolver<User> {

    private final UserTokenParser<UserTokenDetails> userTokenParser;

    public UserResolver(UserTokenParser<UserTokenDetails> userTokenParser) {
        this.userTokenParser = userTokenParser;
    }

    /**
     * {@inheritDoc}
     *
     * This implementation identifies a user and their associated roles from
     * the token using a {@link UserTokenParser}.
     *
     * @return the {@link User} that is the subject of the token
     */
    public User getTokenDetails(String token) {
        UserTokenDetails details = userTokenParser.parse(token);
        return new User(details.getId(), details.getRoles());
    }

}
