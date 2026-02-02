package dvocas13.zadatak1.poslovna_logika;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import dvocas13.zadatak1.util.*;

public class Blog {

    private List<BlogPost> postovi = new ArrayList<>();

    public void dodajPost(BlogPost noviPost){
        if (noviPost == null)
            throw new NullPointerException("Post ne sme biti null");

        postovi.add(noviPost);
    }

    public void sacuvajBlogTXT(String fajl){
        //overwrite rezim
        //append rezim new FileWriter(putanja, true)
        try(PrintWriter out =
                new PrintWriter(new BufferedWriter(new FileWriter(fajl)))){

        for(BlogPost bp : postovi)
           out.println(bp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // tekstualni fajlovi: Reader Writer
    //binarni:   InputStream OutputStream
    //  InputStreamReader

    public void serijalizujBlog(String fajl){
        try(ObjectOutputStream out =
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fajl)))){

        for(BlogPost bp: postovi)
            out.writeObject(bp);

        //out.writeObject(postovi);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deserijalizujBlog(String fajl){
       try(ObjectInputStream in =
               new ObjectInputStream(
                       new BufferedInputStream(
                               new FileInputStream(fajl)))){

        //postovi = (List<BlogPost>) in.readObject();

        postovi.clear();

        try {
               while(true) {
                   BlogPost p = (BlogPost) in.readObject();
                   postovi.add(p);
               }
        }catch (EOFException e){}

       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void ispisi(){
        for(BlogPost bp: postovi)
            System.out.println(bp);
    }

    public List<BlogPost> getPostovi() {
        return postovi;
    }

    public void  sacuvajBlogJSON(String fajl){
        try(PrintWriter out =
                    new PrintWriter(new BufferedWriter(new FileWriter(fajl)))) {

            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().
                    registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).create();

            gson.toJson(postovi, out);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
