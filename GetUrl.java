package com.Aether97.JavaUrlBuilder;

import com.Aether97.JavaUrlBuilder.exceptions.BadUrlException;
import com.Aether97.JavaUrlBuilder.exceptions.GetUrlCreatorException;
import com.Aether97.JavaUrlBuilder.exceptions.BadParameterException;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;


public class GetUrl {
    private String serverUrl;
    private ArrayList<Parameter> parameters;
    private ArrayList<String> path;

    public GetUrl(String serverUrl) throws GetUrlCreatorException {
        if (serverUrl == null)
            throw new BadUrlException("Url is null!");
        if(!serverUrl.startsWith("http://") && !serverUrl.startsWith("https://"))
                throw new BadUrlException("Url doesn't start with http:// or https://");
        if(!serverUrl.contains("."))
            throw new BadUrlException("Url doens't contain any domains");

        this.serverUrl = serverUrl;
        this.parameters = new ArrayList<Parameter>();
        this.path =  new ArrayList<String>();
    }


    public void setParameters(ArrayList<Parameter> parameters){
        this.parameters = parameters;
    }

    public void setPath(ArrayList<String> path){
        this.path = path;
    }

    public ArrayList<String> getPath(){
        return path;
    }

    public ArrayList<Parameter> getParameters(){
        return parameters;
    }

    private GetUrl returnCopy(String serverUrl,ArrayList<Parameter> parameters,ArrayList<String> path) throws GetUrlCreatorException{
        GetUrl newUrl = new GetUrl(serverUrl);
        newUrl.setParameters(parameters);
        newUrl.setPath(path);
        return newUrl;
    }

    public GetUrl addParameter(String key,String value) throws GetUrlCreatorException{
        if(key==null || value==null)
            throw new BadParameterException();
        parameters.add(new Parameter(key,value));
        return returnCopy(serverUrl,this.parameters,this.getPath());
    }

    public GetUrl addPath(String path) throws GetUrlCreatorException{
        this.path.add(path);
        return returnCopy(this.serverUrl,this.parameters,this.path);
    }

    public String build(){
        StringBuilder url = new StringBuilder(this.serverUrl);
        int i = 0;

        if(!path.isEmpty())
        for (i = 0; i < this.path.size(); i++) {
                String adding =  path.get(i);
                url.append(adding);
        }

        if(!parameters.isEmpty())
        for (i = 0; i < this.parameters.size(); i++) {
            if(i==0){
                String adding = "?" + parameters.get(i).getKey() +"=" + parameters.get(i).getValue();
                url.append(adding);
            }
            else{
                String adding = "&" + parameters.get(i).getKey() + "=" + parameters.get(i).getValue();
                url.append(adding);
            }
        }
        return url.toString();
    }

}
