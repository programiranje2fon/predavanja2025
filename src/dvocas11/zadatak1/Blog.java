package dvocas11.zadatak1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Blog {

    private List<BlogPost> postovi = new ArrayList<>();

    public void dodajPost(BlogPost noviPost){
        if (noviPost == null)
            throw new NullPointerException("Post ne sme biti null");

        postovi.add(noviPost);
    }

    public void sacuvajBlogTXT(String putanja){
        //overwrite rezim
        //append rezim new FileWriter(putanja, true)
        try(PrintWriter out =
                new PrintWriter(new BufferedWriter(new FileWriter(putanja)))){

        for(BlogPost bp : postovi)
           out.println(bp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // tekstualni fajlovi: Reader Writer
    //binarni:   InputStream OutputStream
    //  InputStreamReader

    public void serijalizujBlog(){
        try(ObjectOutputStream out =
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("blog.dat")))){

        for(BlogPost bp: postovi)
            out.writeObject(bp);

        //out.writeObject(postovi);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deserijalizujBlog(){
       try(ObjectInputStream in =
               new ObjectInputStream(
                       new BufferedInputStream(
                               new FileInputStream("blog.dat")))){

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


}
