package cn.idocode.confluence.restapi;

import cn.idocode.confluence.model.ResultMsg;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.atlassian.sal.api.transaction.TransactionTemplate;
import com.atlassian.sal.api.user.UserManager;
import com.atlassian.sal.api.user.UserProfile;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demo")
@Scanned
public class RestApiDemo {

    @ComponentImport
    private UserManager userManager;
    @ComponentImport
    private TransactionTemplate transactionTemplate;

    @Inject
    public RestApiDemo(UserManager userManager, TransactionTemplate transactionTemplate) {
        this.userManager = userManager;
        this.transactionTemplate = transactionTemplate;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @AnonymousAllowed
    public Response get(@Context HttpServletRequest request) {
        if (!checkUserHasLogin(request)) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok(this.transactionTemplate.execute(
                () -> {
                    ResultMsg resultMsg = new ResultMsg();
                    Gson gson = new Gson();
                    return gson.toJson(resultMsg);
                }
        )).build();
    }

    private boolean checkUserHasLogin(HttpServletRequest request) {
//        boolean result = false;
//        UserProfile userProfile = this.userManager.getRemoteUser(request);
//        if (userProfile != null) {
//            String userName = userProfile.getUsername();
//            result = userName != null && this.userManager.isSystemAdmin(userName);
//        }
//        return result;
        return true;
    }

}
