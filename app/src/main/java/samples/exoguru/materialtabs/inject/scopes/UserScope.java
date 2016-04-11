package samples.exoguru.materialtabs.inject.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by TAE on 08/04/2016.
 */

@Scope
@Retention(RUNTIME)
public @interface UserScope {
}
