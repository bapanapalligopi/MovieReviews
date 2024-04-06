package com.greviews.MovieReviews.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateSearchRequest
{
    @NotBlank
    private String key;
    @NotBlank
    private String op;
    @NotBlank
    private String value;

    private  static Set<String> allowedKeys=new HashSet<>();
    private static Map<String, List<String>> allowedOps=new HashMap<>();

    CreateSearchRequest()
    {
        allowedKeys.addAll(Arrays.asList("title","genre","duration","rating","director"));
        allowedOps.put("title",Arrays.asList("=","Like"));
        allowedOps.put("genre",Arrays.asList("=","Like"));
        allowedOps.put("director",Arrays.asList("=","Like"));
        allowedOps.put("duration",Arrays.asList("=",">=","<=",">","<"));
        allowedOps.put("rating",Arrays.asList("=",">=","<=",">","<"));
    }
    public boolean validate(CreateSearchRequest csr)
    {
        //checking for valid search key or not
        if(!allowedKeys.contains(csr.getKey())) return false;
        List<String> validOps=allowedOps.get(csr.getKey());
        if(!validOps.contains(csr.getOp())) return false;
        return  true;
    }
}
