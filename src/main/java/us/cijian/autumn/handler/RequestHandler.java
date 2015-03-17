package us.cijian.autumn.handler;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luohao4 on 2015/3/17.
 */
public class RequestHandler {

    private ServletRequest request;
    private ServletResponse response;

    public synchronized static RequestHandler getInstance(final HttpServletRequest req, final HttpServletResponse res) {
        return new RequestHandler() {{
            this.request = req;
            this.response = res;
        }};
    }

    public void deal() {
        System.out.println(request);
        System.out.println(response);
    }

}
