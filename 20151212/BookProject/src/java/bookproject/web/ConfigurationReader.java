package bookproject.web;

import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author student
 */
public class ConfigurationReader {

    private ArrayList<ActionConfig> actionList;
    private String file;

    public ConfigurationReader(String file) {
        this.file = file;
        actionList = new ArrayList<>();
    }

    public ArrayList<ActionConfig> parse() {
        SAXParserFactory factory = null;
        SAXParser saxParser = null;

        try {
            factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();
            saxParser.parse(file, new Parser());
            
        } catch (Exception ex) {
            System.err.println("Error parsing action config file");
            throw new RuntimeException("Error parsing action config file", ex);
        }
        
        return actionList;
    }

    class Parser extends DefaultHandler {
        boolean action = false;
        boolean name = false;
        boolean page = false;
        boolean clas = false;
        boolean forward = false;
        boolean output = false;
        
        ActionConfig baseAction = null;

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (action) {

                if (name) {
                    baseAction.setName(new String(chars, start, length));
                }

                if (page) {
                    baseAction.setPage(new String(chars, start, length));
                }

                if (clas) {
                    baseAction.setClassName(new String(chars, start, length));
                }

                if (forward) {
                    String value = new String(chars, start, length);
                    if (value.equalsIgnoreCase("true")) {
                        baseAction.setForward(true);
                    } else {
                        baseAction.setForward(false);
                    }
                }

                if (output) {
                    String value = new String(chars, start, length);
                    if (value.equalsIgnoreCase("true")) {
                        baseAction.setOutput(true);
                    } else {
                        baseAction.setOutput(false);
                    }
                }

            }
        }

        @Override
        public void startElement(String uri,
                String localName,
                String qName,
                Attributes attributes) throws SAXException {
            
            if (qName.equals("action")) {
                action = true;
                baseAction = new ActionConfig();
            }

            if (qName.equals("name")) {
                name = true;
            }

            if (qName.equals("page")) {
                page = true;
            }

            if (qName.equals("class")) {
                clas = true;
            }

            if (qName.equals("forward")) {
                forward = true;
            }

            if (qName.equals("output")) {
                output = true;
            }

        }

        @Override
        public void endElement(String uri,
                String localName,
                String qName) throws SAXException {
            
            if (qName.equals("action")) {
                action = false;
                actionList.add(baseAction);
            }

            if (qName.equals("name")) {
                name = false;
            }

            if (qName.equals("page")) {
                page = false;
            }

            if (qName.equals("class")) {
                clas = false;
            }

            if (qName.equals("forward")) {
                forward = false;
            }

            if (qName.equals("output")) {
                output = false;
            }
        }

       

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Started processing document");
        }
        
        
         @Override
        public void endDocument() throws SAXException {
            System.out.println("Finished processing document");
        }

    }

}
