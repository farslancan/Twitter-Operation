/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitteroperation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import twitter4j.*;
import twitter4j.IDs;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Osman
 */
public class TwitterOperation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException, IOException {
        
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
               cb.setDebugEnabled(true)
                .setOAuthConsumerKey("6xZxAX9fQ2jyI3RgfsWpUYzrb")
                .setOAuthConsumerSecret("PjjXVYXu3pasWKZoYmrlnmROt1fTZ9UHUyAlV2dMM2pHbada2u")
                .setOAuthAccessToken("387655134-W8XIVy5o1rvEBblHja7LBVUzzUNAvPYoRqF2LDk3")
                .setOAuthAccessTokenSecret("uCFnWyYA3iEBaZjXBeamKz5GxS0HTwyCGCL7MUkITHCRl");
               
               TwitterFactory tf = new TwitterFactory(cb.build());
               
               twitter4j.Twitter twitter=tf.getInstance();
             
               ////
               
               
               
               
               
               ////
       
               List<Status> statuses;
             
            String user;
            if (args.length == 1 ) {
                user = args[0];
              
                statuses = twitter.getUserTimeline(user);
            } else {
                user = twitter.verifyCredentials().getScreenName();
                statuses = twitter.getUserTimeline(user);
            }
        //    System.out.println("Showing @" + user + "'s user timeline.");
            for (Status status : statuses) {
               
              //  System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }      
       
            
                           Paging paging = new Paging();
paging.setCount(2000); 
                 long lCursor = -1;
IDs friendsIDs = twitter.getFriendsIDs(user, lCursor);
System.out.println(twitter.showUser(user).getName());
System.out.println("==========================");
     String statusname;
     String write;
     File f=new File("C:\\Users\\Osman\\Desktop\\gg\\work.txt");
                   FileWriter fw=new FileWriter(f); 
do
{
  for (long i : friendsIDs.getIDs())
   {
               statusname = twitter.showUser(i).getScreenName();           
      System.out.println(twitter.showUser(i).getName());
       
       
       List<twitter4j.Status> statuses1= twitter.getUserTimeline("@"+statusname, paging);
             for (twitter4j.Status status1: statuses1)
            {
                 for (Status status : statuses) {
                   if(status.getText().contains("#"))
                     if( status1.getText().toLowerCase().contains(status.getText().toLowerCase()) || status.getText().toLowerCase().contains(status1.getText().toLowerCase()))
                     {  System.out.println(status1.getUser().getName() + ":" + status1.getText());
                   write=(status1.getUser().getName() + ":" + status1.getText());
                 fw.write(write);
                 fw.write("\r\n");}
                   
                 
               
             }}
       
       
   }
}while(friendsIDs.hasNext());
    fw.close(); 
        System.out.println("------------------------- ");
    
        
        
        
        
        
        
        
        
         System.out.println("------------------------- ");

  
        
     
    
               
          
      
    }
}
