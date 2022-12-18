import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// Tirado dos foruns do DevMedia - Postado por Vitor Pamplona - 09/04/2009
public class TextDocument extends PlainDocument {
    /**
     * Tamanho máximo default do componente = 4000 caracteres
    */
    private int tamanhoMax = 4000;
 
    /**
     * Cria o validador com o tamanho máximo de 4000
    */
    public TextDocument() {
        super();
    }
  
    /**
     * Cria o validador com o tamanho definido no parâmetro
     * 
     * @param tamanho Tamanho máximo da cadeia de caracteres
     */
    public TextDocument(int tamanho) {
        super();
        tamanhoMax = tamanho;
    }
    /**
     * A cada tecla pressionada valida a tecla verifica se não está no máximo que o campo pode aguentar.
     * 
     * @see javax.swing.text.Document#insertString(int, java.lang.String, javax.swing.text.AttributeSet)
     */
    public void insertString(int offs, String str, AttributeSet a) 
         throws BadLocationException {
  
         if (str == null) return;
              
         String oldString = getText (0, getLength() );
         String newString = oldString.substring(0, offs) + str + oldString.substring(offs); 
                  
         if (newString.length() > tamanhoMax) {
            super.insertString(offs, "", a);
         } else {
            // Repassa para o pai.
            super.insertString(offs, str, a);
         }
                 
    }
}
