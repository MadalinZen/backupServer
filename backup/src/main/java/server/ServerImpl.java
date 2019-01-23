package server;

import api.Server;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class ServerImpl implements Server {

    private List<String> filesContents = new LinkedList<String>();

    public boolean search(String fileContent) {

        if (fileContent == null) {

            return false ;
        }

        Optional<String> foundElement = filesContents.stream()

        .filter(existingItem->existingItem.equals(fileContent))
         .findFirst();

                return foundElement.isPresent();

    }

    public boolean download(InputStream file) {

        if (file == null) {

            return false;
        }


        byte[] contents = new byte[1024];

        int bytesRead= 0 ;

        String strFilesContents= "";

        try {

            while ((bytesRead = file.read(contents)) != -1) {

                strFilesContents += new String(contents, 0, bytesRead);
            }

             file.close();

        }catch(IOException ioException) {

            return false;

        }

        System.out.println(strFilesContents);
        filesContents.add(strFilesContents);
        return true;
    }

//    public void close() {
//
//    }

    public void list() {

    }

    public void getStatus() {

    }
}
