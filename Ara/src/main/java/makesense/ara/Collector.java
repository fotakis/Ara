/*
 * This file is part of Ara toolkit.

    Ara is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Ara is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Ara.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * The Collector class is responsible to connect to the stream and 
 * provides the content to further analysis
 * @author mphuget
 * @since 1.0
 */
package makesense.ara;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * The Collector class connects to the streaming and stores the data for further
 * use
 * 
 * @author mphuget
 */
public class Collector extends Thread {

	// the data attribute stores information such as:
	// login and password to access the streaming
	// streaming URL
	private HashMap<String, String> data = null;

	// for stopping the streaming
	private boolean stop = false;

	public Collector(HashMap<String, String> data) {

		//store the connection information
		this.data = data;

	} // constructor

	/**
	 * run() connects to the streaming
	 */
	public void run() {

		// connect to the streaming
		connect();

	} // run()

	private void connect() {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		try {

			// for the moment, we use AuthScope.ANY and SingleAuth
			// in the future, think about MultiAuth to allow several accounts
			httpclient.getCredentialsProvider().setCredentials(
					AuthScope.ANY,
					new UsernamePasswordCredentials(
							data.get("login"), data.get("password")));

			HttpGet httpget = new HttpGet(data.get("URL"));

			HttpResponse httpResponse = httpclient.execute(httpget);
			HttpEntity entity = httpResponse.getEntity();

			if (entity != null) {

				InputStream instream = entity.getContent();
				String content;
				BufferedReader br = new BufferedReader(new InputStreamReader(
						instream));

				// we read as long as we do not ask to stop
				while (!stop) {

					content = br.readLine();
					if (content != null) {

						System.out.println(content);
						
					} // if

				} // while

			} // if

		} // try
		
		catch (IOException ioe) {

			ioe.printStackTrace();

		} // catch
		
		finally {

			httpclient.getConnectionManager().shutdown();

		} // finally
		
	} // connect()

} // Collector class
