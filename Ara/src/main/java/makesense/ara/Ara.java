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
 * The Ara toolkit relies on the following libraries: 
 * Apache httpclient
 * Apache httpcore
 * Apache commons-logging
 * Apache commons-codec
 */
package makesense.ara;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import makesense.ara.utils.ConnectionInfo;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * The Ara class is the main entry in the Ara toolkit, it requires one argument
 * corresponding to the file containing connection configuration and the URL to
 * retrieve
 * 
 * @author mphuget
 * @since 1.0
 */
public class Ara extends Thread {

	// store the different information required for connection
	HashMap<String, String> data = null;

	public Ara(String file) {

		data = new HashMap<String, String>();

		// populates the data attribute with connection information
		getConnectionData(file);

		// show the information about this application
		usage();

	} // constructor

	/**
	 * run() is called on start() invocation, it runs the <b>Collector<b> to
	 * retrieve data from the stream
	 */
	public void run() {

		// one unique task in the run(): creates a Collector to connect to the
		// streaming
		new Collector(data).start();

	} // run()

	/**
	 * getConnectionData() retrieves connection information
	 */
	private void getConnectionData(String stFile) {

		try {

			File file = new File(stFile);
			InputStream inputStream;
			inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream, "ISO-8859-1");

			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");

			XMLReader saxReader = XMLReaderFactory.createXMLReader();
			ConnectionInfo sr = new ConnectionInfo();
			saxReader.setContentHandler(sr);
			saxReader.parse(is);

			data.put("login", sr.getLogin());
			data.put("password",sr.getPassword());
			data.put("URL", sr.getURL());

		} // try
		
		catch (FileNotFoundException e) {

			e.printStackTrace();

		} // catch
		
		catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		} // catch
		
		catch (SAXException e) {

			e.printStackTrace();

		} // catch
		
		catch (IOException e) {

			e.printStackTrace();

		} // catch

	} // getConnectionData

	/**
	 * prints out header for this toolkit
	 */
	private void usage() {

		System.err.println("Ara toolkit");
		System.err.println("available on GitHub https://github.com/mphuget/Ara");
		System.err.println("Provides tasks to retrieve and does real-time analysis");
		System.err.println("on continuous streaming");
		System.err.println("Marc-Philippe Huget");
		System.err.println("Please visit the GitHub repository for more information");
		System.err.println("Supply connection file on the command-line argument");

	} // usage()

	/**
	 * main() used to run the Ara toolkit
	 * 
	 * @param args
	 *            the command-line arguments
	 */
	public static void main(String[] args) {

		// check whether the user has provided a unique argument corresponding
		// to the
		// connection file
		if (args.length == 1) {

			// create an instance of Ara as a Thread and execute it
			new Ara(args[0]).start();

		} // if

		else {

			// throws an exception regarding the number of arguments
			throw new ArrayIndexOutOfBoundsException(
					"Wrong number of arguments: java makesense.ara.Ara <configuration file>");

		} // else

	} // main()

} // Ara class
