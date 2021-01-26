package objetos;

import java.util.HashMap;
import subItens.*;

public abstract class Item {
	protected float valor;
    protected String nome;
    public static int p;

        private static HashMap<String, Item> itens = new HashMap<String, Item>();
        
        public static Item getInstance(String id){
            Item i=itens.get(id);
            if(i!=null)
                return i;
            if(id.equalsIgnoreCase("banheiro"))
                i= new Banheiro();
            else if(id.equalsIgnoreCase("cama casal"))
                i = new CamaC();
            else if(id.equalsIgnoreCase("cama solteiro"))
                i = new CamaS();
            else if(id.equalsIgnoreCase("internet"))
                i = new Internet();
            else if(id.equalsIgnoreCase("tv"))
                i = new Tv();
            if(i!=null)
                itens.put(id,i);
            return i;    
        }
        
        public Item(){
            valor =10;
            nome = null;
        }
        
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
        
        public String getNome() {
        return nome;
        }
}
