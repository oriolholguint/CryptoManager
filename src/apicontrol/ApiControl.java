package apicontrol;

import elements.Crypto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiControl 
{    
    private static HttpURLConnection connection;
    
    /**
     * Lanza una petición de tipo GET a la API y devuelve la respuesta en JSON
     * @param urlText enlace de la petición.
     * @return resultado de la petición en formato JSON.
     */
    public static String connectApi(String urlText)
    {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        
        try
        {
            URL url = new URL(urlText);
           
            connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            /* PARA POSIBLE CONTRASEÑA DE LA API
            connection.addRequestProperty("X-CMC_PRO_API_KEY", "3cd31617-6549-4955-8fc9-1e8c454f6a54");
            */
            int status = connection.getResponseCode();
            
            //System.out.println(status); //DEBUG del estado para la conexión
                        
            if(status > 299)
            {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null)
                {
                    responseContent.append(line);
                }
                reader.close();
            }
            else
            {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null)
                {
                    responseContent.append(line);
                }
                reader.close();
            }
        }
        catch(MalformedURLException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }finally{
            connection.disconnect();
        }
        
        return responseContent.toString();
    }
    
    //===============================================
    //Parse JSON file to an array
    public static ArrayList<Crypto> parseToArray (String responseBody) 
    {
        ArrayList<Crypto> cryptoList=new ArrayList();
        
        try{
            JSONArray cryptos = new JSONArray(responseBody);

            for (int i = 0; i<cryptos.length();i++)
            {
                JSONObject crypto = cryptos.getJSONObject(i);
                String id = crypto.getString("id");
                String symbol = crypto.getString("symbol");
                String name = crypto.getString("name");
                cryptoList.add(new Crypto(id, symbol, name)); //Añade la lista de albumes desde el archivo JSON.
            }
        } catch (JSONException ex) {
                System.out.println("No se pudo parsear el JSON" + ex);
                ex.printStackTrace();
        }
            
            return cryptoList;
    }
    
    /**
     * Obten un array de la lista de criptomonedas de la API.
     * @param responseBody consulta de la API en formato JSON.
     * @return Lista con los nombres de todas las criptomonedas.
     */
    public static ArrayList<String> parseCryptoList (String responseBody) 
    {
        ArrayList<String> cryptoList=new ArrayList();
        
        try{
            JSONArray cryptos = new JSONArray(responseBody);

            for (int i = 0; i<cryptos.length();i++)
            {
                JSONObject crypto = cryptos.getJSONObject(i);
                String id = crypto.getString("id");
                cryptoList.add(id);
            }
        } catch (JSONException ex) {
                System.out.println("No se pudo parsear el JSON" + ex);
                ex.printStackTrace();
        }
            
            return cryptoList;
    }
        
     //Parse JSON file to an object
    public static Crypto parseToObject (String responseBody)
    {
        Crypto crypto=null;
        try{
            JSONObject album = new JSONObject(responseBody);

            String id = album.getString("id");
            String symbol = album.getString("symbol");
            String name = album.getString("name");

            crypto=new Crypto(id, symbol,name); //Añade la lista de albumes desde el archivo JSON.
        
        } catch (JSONException ex) {
                System.out.println("No se pudo parsear el JSON" + ex);
                ex.printStackTrace();
        }
        
        return crypto;
    }
    
    
        //==================================
        /* CON GSON =======================
        //==================================
        String json="";
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("datos.json"));
            
            String line;
            
            while((line = br.readLine()) != null){
                json += line;
            }
            
            br.close();
            
        }catch(FileNotFoundException ex){
            System.out.println("");
        }catch (IOException ex){
            System.out.println("");
        }
        
        Gson gson = new Gson();
        Crypto c = gson.fromJson(json, Crypto.class);
        
        System.out.println(c);
        */
    
}