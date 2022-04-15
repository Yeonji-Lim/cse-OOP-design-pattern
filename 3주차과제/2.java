
class Text {

    String text;
    String author;
    int length;

    String getText() { ... }
    void setText(String s) { ... }
    String getAuthor() { ... }
    void setAuthor(String s) { ... }
    int getLength() { ... }
    void setLength(int k) { ... }

}

class TextChanger {
    Text targetText;
    
    /*methods that change the text*/
    void allLettersToUpperCase() { ... }
    void findSubTextAndDelete(String s) { ... }

}

class printer {
    Text targetText;

    /* method for formatting output */
    void printText() { ... }
}
