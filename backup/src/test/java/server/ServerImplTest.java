package server;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServerImplTest {

    FileInputStream file ;

     public InputStream citireDinFile() throws FileNotFoundException {

         ClassLoader classLoader = getClass().getClassLoader();
         File file = new File(classLoader.getResource("myData.txt").getFile());
         InputStream fileStream = new FileInputStream(file) ;


         return fileStream ;
     }
    @Test
    public void itDownloadACopyOfTheStream() throws IOException {

        //Give
        ServerImpl systemUnderTest = new ServerImpl();

        InputStream file = citireDinFile();



        //When


        boolean result = systemUnderTest.download(file);

        //Then
        assertTrue(result);
    }

    @Test
    public void itFailsToDownLoadFileWhenInputIsNull() throws IOException {

        //Given

        ServerImpl systemUnderTest = new ServerImpl();

        //When

        boolean result = systemUnderTest.download(null);

        // Then

        assertFalse(result);

    }

    @Test
    public void itFindsTheGiveFileContentsOnTheServer() throws FileNotFoundException {

        // Given

        ServerImpl systemUnderTest = new ServerImpl();

        InputStream file = citireDinFile();

        // When

        boolean result = systemUnderTest.search("123");

        // Then

        assertTrue(result);
    }



}