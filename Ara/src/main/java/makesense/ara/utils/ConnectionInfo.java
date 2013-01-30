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
 * The ConnectionInfo class retrieves the URL for the streaming and the
 * login and password required to access the streaming
 * @author mphuget
 * @since 1.0
 */
package makesense.ara.utils;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class ConnectionInfo implements ContentHandler {

	//tags in the XML file
	private boolean bLogin = false;
	private boolean bPassword = false;
	private boolean bURL = false;
	
	//content of the tags in the XML file
	private String login = null;
	private String password = null;
	private String URL = null;
	
	/**
	 * Constructor
	 */
	public ConnectionInfo() {

	} //constructor
	
	/**
	 * setDocumentLocator allows to retrieve on which line and column the caret is 
	 * when reading the file
	 */
	public void setDocumentLocator(Locator locator) {

		//Note: left blank intentionally
		
	} //setDocumentLocator()

	/**
	 * startDocument is called when starting reading the document
	 */
	public void startDocument() throws SAXException {
		
		//Note: left blank intentionally
		
	} //startDocument()

	/**
	 * endDocument is called when finishing reading the document
	 */
	public void endDocument() throws SAXException {
		
		//Note: left blank intentionally
		
	} //endDocument()

	/**
	 * startPrefixMapping is called when starting a new namespace
	 */
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		
		//Note: left blank intentionally
		
	} //startPrefixMapping()

	/**
	 * endPrefixMapping is called when finishing a namespace
	 */
	public void endPrefixMapping(String prefix) throws SAXException {
		
		//Note: left blank intentionally
		
	} //endPrefixMapping()

	/**
	 * startElement is called when an opening tag is on the stream
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		
		//we check according the different tags in the XML file
		if (localName.equals("login"))
			bLogin = true;
		
		if (localName.equals("password"))
			bPassword = true;

		if (localName.equals("URL"))
			bURL = true;

	} //startElement()

	/**
	 * endElement is called on closing tag on the stream
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if (localName.equals("login"))
			bLogin = false;
		
		if (localName.equals("password"))
			bPassword = false;
		
		if (localName.equals("URL"))
			bURL = false;
		
		
	} //endElement()

	/**
	 * characters is called when reading the content between a pair of tags
	 */
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		//based on the opening tag, we set the correct variable
		if (bLogin)
			login = new String(ch, start, length);
		
		if (bPassword) 
			password = new String(ch, start, length);
		
		if (bURL) 
			URL = new String(ch, start, length);

	} //characters()

	/**
	 * ignorableWhitespace is called every time a whitespace can be ignored
	 */
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		
		//Note: left blank intentionally
		
	} //ignorableWhitespace()

	public void processingInstruction(String target, String data)
			throws SAXException {
		
		//Note: left blank intentionally
		
	} //processingInstruction()

	public void skippedEntity(String name) throws SAXException {
		
		//Note: left blank intentionally
		
	} //skippedEntity()
	
	/**
	 * getLogin returns the login coming from the XML file
	 * @return the login
	 */
	public String getLogin() {
		
		return login;
		
	} //getLogin()
	
	/**
	 * getPassword returns the password coming from the XML file
	 * @return the password
	 */
	public String getPassword() {
		
		return password;
		
	} //getPassword()

	/**
	 * getURL returns the URL coming from the XML file
	 * @return the URL
	 */
	public String getURL() {
		
		return URL;
		
	} //getURL()
	
} //ConnectionInfo class
