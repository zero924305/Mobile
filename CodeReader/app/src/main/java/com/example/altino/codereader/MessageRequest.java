package com.example.altino.codereader;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class MessageRequest extends StringRequest
{
    private static final String MESSAGE_REQUEST_URL = "http://stul641.lccwebtest.co.uk/admin/message.php";
    private Map<String, String> params;

    public MessageRequest(String title, String message, Response.Listener<String> listener)
    {
        super(Request.Method.POST,MESSAGE_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("title", title);
        params.put("message", message);
    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }

}
