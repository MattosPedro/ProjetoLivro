import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

//classe livro
class Livro {
		//atributos
	private	long ISBN;
	private	String titulo,autor_principal,autor_secundario,categoria,descricao;
	private int ano,paginas,avaliacoes;
	private double notas;
	//arquivo
	public static String getPathArquivo() {
		String os= System.getProperty("os.name");
		if(os.contains("Windows"))
			return "livros.txt";
		else
			return"/tmp/livros.txt";
	}
	
		//metodos geteres e seteres
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor_principal() {
		return autor_principal;
	}
	public void setAutor_principal(String autor_principal) {
		this.autor_principal = autor_principal;
	}
	public String getAutor_secundario() {
		return autor_secundario;
	}
	public void setAutor_secundario(String autor_secundario) {
		this.autor_secundario = autor_secundario;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(int avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public double getNotas() {
		return notas;
	}
	public void setNotas(double notas) {
		this.notas = notas;
	}
	//metodo de leitura 
	public void ler(String texto){
		String textoseparado[]= texto.split("\\|");
		this.ISBN=Long.parseLong(textoseparado[0]);
		this.titulo=textoseparado[1];
		this.autor_principal=textoseparado[2];
		this.autor_secundario=textoseparado[3];
		this.categoria=textoseparado[4];
		this.descricao=textoseparado[5];
		this.ano=Integer.parseInt(textoseparado[6]);
		this.paginas=Integer.parseInt(textoseparado[7]);
		this.notas=Double.parseDouble(textoseparado[8]);
		this.avaliacoes=Integer.parseInt(textoseparado[9]);
	}
	//metodo ToString baseada em leitura do verde
	public String toString() {
		if(!this.autor_secundario.equals("")) {
			return"["+this.categoria+"] ["+this.notas+"] ["+this.avaliacoes+"] "+ this.autor_principal+", "+this.autor_secundario+". "+this.titulo+". "+Integer.toString(this.ano)+". "+"ISBN: "+Long.toString(this.ISBN)+". ";
		}
		else {
            return "["+this.categoria+"] ["+this.notas+"] ["+this.avaliacoes+"] "+ this.autor_principal + ". " + this.titulo + ". " + Integer.toString(this.ano) + ". ISBN: " + Long.toString(this.ISBN) + ". ";   

		}
		
	}
	//impirmir
	public void imprimir() {
		MyIO.println(toString());
	}
	//meodo clone
	public Livro Clone() {
		Livro clone=new Livro();
		  clone.setISBN(this.ISBN);
	      clone.setTitulo(this.titulo);
	      clone.setAutor_principal(this.autor_principal);
	      clone.setAutor_secundario(this.autor_secundario);
	      clone.setCategoria(this.categoria);
	      clone.setDescricao(this.descricao);
	      clone.setAno(this.ano);
	      clone.setPaginas(this.paginas);
	      clone.setAvaliacoes(this.avaliacoes);
	      clone.setNotas(this.notas);
	      
	      return clone;
	}
	//se é maior
	public static boolean ehMaior(Livro a, Livro b/*, Log log*/) {
	   // log.setComp(1);

	    int Compara = a.getCategoria().compareTo(b.getCategoria());
	    if (Compara > 0) {
	        return true;
	    } else if (Compara == 0) {
	        //log.setComp(2);

	        if (a.getNotas() < b.getNotas()) {
	            return true;
	        } else if (a.getNotas() == b.getNotas()) {
	            //log.setComp(2);

	            if (a.getAvaliacoes() < b.getAvaliacoes()) {
	                return true;
	            } else if (a.getAvaliacoes() == b.getAvaliacoes()) {
	                //log.setComp(1);
	            }
	        }
	    }
	   // log.setComp(1);
	    return false;
	}
	//se é menor
	public static boolean ehMenor(Livro a, Livro b, Log log) {
	    log.setComp(1);

	    int Compara = a.getCategoria().compareTo(b.getCategoria());
	    if (Compara < 0) {
	        return true;
	    } else if (Compara == 0) {
	        log.setComp(2);

	        if (a.getNotas() > b.getNotas()) {
	            return true;
	        } else if (a.getNotas() == b.getNotas()) {
	            log.setComp(2);

	            if (a.getAvaliacoes() > b.getAvaliacoes()) {
	                return true;
	            } else if (a.getAvaliacoes() == b.getAvaliacoes()) {
	                log.setComp(1);
	            }
	        }
	    }
	    log.setComp(1);
	    return false;
	}

	//metodo de swap (troca)
	public static void swap(Livro a, Livro b) {
		Livro l=a.Clone();
		a.setISBN(b.getISBN());
		a.setAno(b.getAno());
		a.setAutor_principal(b.getAutor_principal());
		a.setAutor_secundario(b.getAutor_secundario());
		a.setAvaliacoes(b.getAvaliacoes());
		a.setCategoria(b.getCategoria());
		a.setDescricao(b.getDescricao());
		a.setNotas(b.getNotas());
		a.setPaginas(b.getPaginas());
		a.setTitulo(b.getTitulo());
		b.setISBN(l.getISBN());
		b.setAno(l.getAno());
		b.setAutor_principal(l.getAutor_principal());
		b.setAutor_secundario(l.getAutor_secundario());
		b.setAvaliacoes(l.getAvaliacoes());
		b.setCategoria(l.getCategoria());
		b.setDescricao(l.getDescricao());
		b.setNotas(l.getNotas());
		b.setPaginas(l.getPaginas());
		b.setTitulo(l.getTitulo());
		
		
	}
	//		METODOS DE ORDENAÇÃO

	// BUBBLE SORT
	public static void bobble(ArrayList<Livro> bob, Log log) {
	    for (int i = 0; i < bob.size(); i++) {
	        for (int j = 0; j < bob.size()-i - 1; j++) {
	            if (ehMaior(bob.get(j), bob.get(j + 1), log)) {
	                swap(bob.get(j), bob.get(j + 1));
	                log.setMov(1);
	            }
	        }
	    }
	}
	// INSERTION SORT
	public static void insertion(ArrayList<Livro> ins, Log log) {
	    for (int i = 1; i < ins.size(); i++) {
	        Livro tmp = ins.get(i).Clone();
	        int j = i - 1;
	        while (j >= 0 && ehMaior(ins.get(j), tmp, log)) {
	            swap(ins.get(j + 1), ins.get(j));
	            log.setMov(1);
	            j--;
	        }
	        swap(ins.get(j + 1), tmp);
	        log.setMov(1);
	    }
	}
	// SELECTION SORT
	public static void selection(ArrayList<Livro> sel,Log log) {
		for(int i=0;i<(sel.size()-1);i++) {
			int menor=i;
			for(int j=(i+1);j<sel.size();j++) {
				if(ehMaior(sel.get(menor),sel.get(j),log)) {
					menor=j;
				}
			}
			swap(sel.get(menor),sel.get(i));
			log.setMov(1);
		}
	}
	// QUICKSORT
	public static void quicksort(ArrayList<Livro> quick,int low,int high, Log log) {
		if(low<high){
			log.setComp(1);
			int qfy=quickfy(quick,low,high,log);
			quicksort(quick,low,qfy-1,log);
			quicksort(quick,qfy+1,high,log);
		}
	}
	public static int quickfy(ArrayList<Livro>quick,int low,int high,Log log) {
		int i=high;
		for(int j=high;j>low;j--) {
			if(ehMaior(quick.get(j),quick.get(low),log)) {
				swap(quick.get(i--),quick.get(j));
				log.setMov(1);
			}
		}
		swap(quick.get(low),quick.get(i));
		log.setMov(1);
		return i;
	}
	// HEAPSORT
	public static void heapsort(ArrayList<Livro>heap,Log log) {
		int S=heap.size();
		for(int i=S/2-1;i>=0;i--) {
			heapfy(heap,S,i,log);
		}
		for(int i=S-1;i>0;i--) {
			swap(heap.get(0),heap.get(i));
			log.setMov(2);
			heapfy(heap,i,0,log);
		}
	}
	public static void heapfy(ArrayList<Livro>heap,int S,int i,Log log) {
		int maior=i;
		int e=2*i+1;
		int d=2*i+2;
		
		if(e<S && ehMaior(heap.get(e),heap.get(maior),log)){
			maior=e;
		}
		if(d<S && ehMaior(heap.get(d),heap.get(maior),log)){
			maior=d;
		}
		if(maior !=i) {
			swap(heap.get(i),heap.get(maior));
			log.setMov(2);
			heapfy(heap,S,maior,log);
		}
	}

	// MAIN
	public static void main(String[]args) {	
		//main e charset
		MyIO.setCharset("UTF-8");
		String texto;
		//instancianto arquivo de leitura
		ArquivoTextoLeitura lerArq = new ArquivoTextoLeitura(getPathArquivo());
		int q=2000, cnt=0;
		Livro livros[]=new Livro[q];
		texto=lerArq.ler();
		//leitura do texto
		while(texto!=null) {
			livros[cnt]=new Livro();
			livros[cnt].ler(texto);
			texto = lerArq.ler();
			cnt++;
		}
		
		texto=MyIO.readLine();
		
		
		//nova arvore
		//ArrayList<Livro> array=new ArrayList<Livro>();
		//Arvore arvore=new Arvore();
		AVL avl = new AVL();
		//leitura ate o fim
		for(int i=0;!texto.equals("FIM");i++) {
			String textoOk[]=texto.split("\\;");
			int j=0;
			//lido de acordo com verde
			while(j<cnt){
				if(livros[j].getTitulo().equals(textoOk[0])) {
					if(livros[j].getAno()== Integer.parseInt(textoOk[1])) {
						if(livros[j].getAutor_principal().equals(textoOk[2])) {
							avl.inserirAVL(livros[j]);
							break;
						}
					}
				}
				j++;
			}
			texto= MyIO.readLine();
		}
		texto=MyIO.readLine();
		//eitura para equalisar valores
		for(int i=0;!texto.equals("FIM");i++) {
			String textoOk[]=texto.split("\\;");
			int j=0;
			while(j<cnt){
				if(livros[j].getTitulo().equals(textoOk[0])) {
					if(livros[j].getAno()== Integer.parseInt(textoOk[1])) {
						if(livros[j].getAutor_principal().equals(textoOk[2])) {
							avl.pesquisaAVL(livros[j]);
							break;
						}
					}
				}
				j++;
			}
			texto= MyIO.readLine();
		}
		
		ArrayList<Livro> bob=new ArrayList<Livro>();
		ArrayList<Livro> ins=new ArrayList<Livro>();
		ArrayList<Livro> sel=new ArrayList<Livro>();
		ArrayList<Livro> quick=new ArrayList<Livro>();
		ArrayList<Livro> heap=new ArrayList<Livro>();
		
		for(int i=0;i<array.size();i++) {
			bob.add(array.get(i).Clone());
			ins.add(array.get(i).Clone());
			sel.add(array.get(i).Clone());
			quick.add(array.get(i).Clone());
			heap.add(array.get(i).Clone());
		}  
		
		Log logbob=new Log("BUBBLE");
		bobble(bob,logbob);
		
		Log logins=new Log("INSERT");
		insertion(ins,logins);
		
		Log logsel=new Log("SELECT");
		selection(sel,logsel);
		
		for(int i=0;i<bob.size();i++) {
			bob.get(i).imprimir();
		}
		MyIO.println(logbob.toString());
		
		for(int i=0;i<array.size();i++) {
			ins.get(i).imprimir();
		}	
		MyIO.println(logins.toString());
		
		for(int i=0;i<array.size();i++) {
			sel.get(i).imprimir();
		}	
		MyIO.println(logsel.toString());
		
		Log logquick=new Log("QUICK");
		quicksort(quick,0,quick.size()-1,logquick);
		for(int i=0;i<array.size();i++) {
			quick.get(i).imprimir();
		}
		MyIO.println(logquick.toString());
		
		Log logheap=new Log("HEAP");
		heapsort(heap,logheap);
		for(int i=0;i<array.size();i++) {
			heap.get(i).imprimir();
		}
		MyIO.println(logheap.toString());
		*/

	}
}
//classe log
class Log {
	private int mov,comp;
	private String metodo;
	//construtor
	public Log(String metodo) {
		this.mov=0;
		this.comp=0;
		this.metodo=metodo;
	}
	//geteres e seteres
	public int getMov() {
		return mov;
	}

	public int getComp() {
		return comp;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMov(int mov) {
		this.mov+=mov;
	}

	public void setComp(int comp) {
		this.comp+=comp;
	}
	//toStrig do Log
	public String toString() {
		
		return "## "+metodo+" [COMPARACOES] [" + Integer.toString(this.comp/1000)+"k] [MOVIMENTACOES] ["+Integer.toString(this.mov/1000)+"k]"+"\n";
	}
}

//Classe arquivo texto
class ArquivoTextoLeitura {
    //Buufer entrada
	private BufferedReader entrada;
	ArquivoTextoLeitura(String nomeArquivo) {	
		//Try catch para tratativa de erro em leitura de arquivo
		try {
			entrada = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"));
		} catch (UnsupportedEncodingException excecao) {
			System.out.println(excecao.getMessage());
		} catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		}
	}
	//Metodo para fechar arquivo
	public void fecharArquivo() {
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	//Fazer o compilador não emitir warnings
	@SuppressWarnings("finally")
    //Metodo de leitura
	public String ler() {
		String textoEntrada = null;
		try {
			textoEntrada = entrada.readLine();
		}
		catch (EOFException excecao) { //Excecao de final de arquivo.
			textoEntrada = null;
		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		}
		finally {
			return textoEntrada;
		}
	}
}
	//classe celular
	class Celula{
		//atritbutos
		Livro info;
		Celula dir;
		Celula esq;
		int altura;
		public Celula(Livro livro) {
			this.info=livro;
		}	
	}
	//classe arvore livro
	class Arvore extends Livro{
	Celula root;
	//construtor
	public Arvore(Celula root){
		this.root=root;
	}
	public Arvore() {
		
	}
	//metodo de insercao
	public void insercao(Livro livro) {
		root=inserir(livro,root);
	}
	//metodo de insercao completa
	public Celula inserir(Livro livro,Celula info) {
		if(info==null) {
			info=new Celula(livro);
		}
		else if(ehMaior(livro,info.info)) {
			info.dir=inserir(livro,info.dir);
		}
		else if(ehMaior(info.info,livro)) {
			info.esq=inserir(livro,info.esq);
		}
		else {
			return info;
		}
		return info;
	}
	//pesquisa da arvore
	public void colher(Livro livro) {
		boolean aws=pesquisa(livro,root);
		if(aws) {
			MyIO.println(" - SIM");
		}
		else {
			MyIO.println(" - NAO");
		}
	}
	
	//retorna se encontrou ou nao na pesquisa
	public boolean pesquisa(Livro livro,Celula info) {

		if(info==null) {
			return false;
		}
		else if(livro.getTitulo().equals(info.info.getTitulo())) {
			MyIO.println(" - " + info.info.toString());
			return true;
		}
		else if(ehMaior(livro,info.info)) {
			if(info.info.getTitulo().equals(root.info.getTitulo())) {
				MyIO.println(info.info.toString());
			}
			else {
				MyIO.println(" - "+info.info.toString());
			}
			return pesquisa(livro,info.dir);
		}
		else if(ehMaior(info.info,livro)) {
			if(info.info.getTitulo().equals(root.info.getTitulo())) {
				MyIO.println(info.info.toString());
			}
			else {
				MyIO.println(" - "+info.info.toString());
			}
			return pesquisa(livro,info.esq);
		}
		return false;

	}

	}
	
	//classe AVL
	class AVL extends Livro{
		Celula root;
		//classe de uptade
		void updatealtura(Celula atual) {
			atual.altura = 1+Math.max(altura(atual.esq),altura(atual.dir));
		}
		//mostrar aultura
		public int altura(Celula atual) {
			if(atual==null){
				return -1;
			}
			else {
				return atual.altura;
			}
		}
		//verificacao da altura
		int veraltura(Celula atual) {
			if(atual==null) {
				return 0;
			}
			else {
				return altura(atual.dir)-altura(atual.esq);
			}
		}
		//metodo para rotacionar direita
		Celula rotacionarDir(Celula atual) {
			MyIO.println("Rotacionar DIR("+atual.info.toString()+")");
			Celula Filho=atual.esq;
			Celula Neto=Filho.dir;
			Filho.dir=atual;
			atual.esq=Neto;
			updatealtura(atual);
			updatealtura(Filho);
			return Filho;
		}
		//metodo para rotacionar esquerda
		Celula rotacionarEsq(Celula atual) {
			MyIO.println("Rotacionar ESQ("+atual.info.toString()+")");
			Celula Filho=atual.dir;
			Celula Neto=Filho.esq;
			Filho.esq=atual;
			atual.dir=Neto;
			updatealtura(atual);
			updatealtura(Filho);
			return Filho;
		}
		//ver se precisa rotacionar e para qual direcao
		public Celula rebalancear(Celula atual) {
			updatealtura(atual);
			int balancear=veraltura(atual);
			
			if(balancear>1) {
				if(altura(atual.dir.dir)>altura(atual.dir.esq)){					
					atual=rotacionarEsq(atual);
				}
				else {		
					atual.dir=rotacionarDir(atual.dir);	
					atual=rotacionarEsq(atual);
				}
			}
			else if(balancear<-1) {
				if(altura(atual.esq.esq)>altura(atual.esq.dir)) {					
					atual=rotacionarDir(atual);
				}
				else {
					atual.esq=rotacionarEsq(atual.esq);
					atual=rotacionarDir(atual);
				}
			}
			return atual;
		}
		
		//inserir na arvore avl
		public void inserirAVL(Livro livro) {
			root=insercaoAVL(livro,root);
		}
		public Celula insercaoAVL(Livro livro, Celula dado) {
			if(dado==null) {
				return new Celula(livro);
			}
			else if(ehMaior(livro,dado.info)) {
				dado.dir=insercaoAVL(livro,dado.dir);
			}
			else if(ehMaior(dado.info,livro)) {
				dado.esq=insercaoAVL(livro,dado.esq);
			}
			else {
				return rebalancear(dado);
			}
			return rebalancear(dado);
		}
		
		//pesquisar na arovre AVL
		public void pesquisaAVL(Livro livro) {
			boolean aws=pesquisarAVL(livro,root);
			if(aws) {
				MyIO.println(" - SIM");
			}
			else {
				MyIO.println(" - NAO");
			}
		}
		//retorna se encontrou valor
		public boolean pesquisarAVL(Livro livro,Celula dado) {
			if(dado==null) {
				return false;
			}
			else if(livro.getTitulo().equals(dado.info.getTitulo())) {
				MyIO.println(" - " + dado.info.toString());
				return true;
			}
			else if(ehMaior(livro,dado.info)) {
				if(dado.info.getTitulo().equals(root.info.getTitulo())) {
					MyIO.println(dado.info.toString());
				}
				else {
					MyIO.println(" - "+dado.info.toString());
				}
				return pesquisarAVL(livro,dado.dir);
			}
			else if(ehMaior(dado.info,livro)) {
				if(dado.info.getTitulo().equals(root.info.getTitulo())) {
					MyIO.println(dado.info.toString());
				}
				else {
					MyIO.println(" - "+dado.info.toString());
				}
				return pesquisarAVL(livro,dado.esq);
			}
			return false;

		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

