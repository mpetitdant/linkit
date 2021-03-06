package controllers;

import play.mvc.Before;
import play.mvc.Controller;

/**
 * Copie de la classe {@link Secure} de Play!, gérant les redirections vers notre page de login.
 * @author Sryl <cyril.lacote@gmail.com>
 */
public class SecureLinkIt extends Controller {

    @Before(unless={"Profile.register", "Profile.save", "Profile.show", "loginWith", "loginLinkIt", "signup"})
    static void checkAccess() throws Throwable {
        // Authent
        if(!session.contains("username")) {
            Login.index("GET".equals(request.method) ? request.url : "/");
        }
        // Checks
        Check check = getActionAnnotation(Check.class);
        if(check != null) {
            check(check);
        }
        check = getControllerInheritedAnnotation(Check.class);
        if(check != null) {
            check(check);
        }
    }
    
    private static void check(Check check) throws Throwable {
        for(String profile : check.value()) {
            boolean hasProfile = Security.check(profile);
            if(!hasProfile) {
                flash.error("Vous n'avez pas les droits pour accéder à cette URL");
                Application.index();
            }
        }
    }
}
