package com.cotemig.lucas;

class FabricaAbstrataExemplo {

    public static void main(String[] args) {

        FabricaAbstrata fabrica1 = new FabricaConcreta1();
        Cliente cliente1 = new Cliente(fabrica1);
        cliente1.executar();

        FabricaAbstrata fabrica2 = new FabricaConcreta2();
        Cliente cliente2 = new Cliente(fabrica2);
        cliente2.executar();
    }
}

class Cliente {
    private ProdutoAbstratoA produtoA;
    private ProdutoAbstratoB produtoB;

    Cliente(FabricaAbstrata fabrica) {
        produtoA = (ProdutoAbstratoA) fabrica.createProdutoA();
        produtoB = (ProdutoAbstratoB) fabrica.createProdutoB();
    }

    void executar() {
        produtoB.interagir(produtoA);
    }
}

interface FabricaAbstrata {
    ProdutoAbstratoA createProdutoA();
    ProdutoAbstratoB createProdutoB();
}

interface ProdutoAbstratoA {

}

interface ProdutoAbstratoB {
    void interagir(ProdutoAbstratoA a);
}

class FabricaConcreta1 implements FabricaAbstrata {

    @Override
    public ProdutoAbstratoA createProdutoA() {
        return new ProdutoA1();
    }
    @Override
    public ProdutoAbstratoB createProdutoB() {
        return new ProdutoB1();
    }
}

class FabricaConcreta2 implements FabricaAbstrata {

    @Override
    public ProdutoAbstratoA createProdutoA() {
        return new ProdutoA2();
    }
    @Override
    public ProdutoAbstratoB createProdutoB() {
        return new ProdutoB2();
    }
}

class ProdutoA1 implements ProdutoAbstratoA {

}

class ProdutoB1 implements ProdutoAbstratoB {

    @Override
    public void interagir(ProdutoAbstratoA a) {
        System.out.println(this.getClass() + " interage com " + a.getClass());
    }

}

class ProdutoA2 implements ProdutoAbstratoA {

}

class ProdutoB2 implements ProdutoAbstratoB {

    @Override
    public void interagir(ProdutoAbstratoA a) {
        System.out.println(this.getClass() + " interage com " + a.getClass());
    }
    public interface ICloneable {
        public Object clone();
    }

    abstract class Documento implements ICloneable {

        public Documento clone() {

            Object clone = null;

            try {
                clone = super.clone();
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }

            return (Documento) clone;
        }

        public abstract void abrir();
    }

    class ASCII extends Documento {
        @Override
        public void abrir() {

        }
    }

    class PDF extends Documento {
        @Override
        public void abrir() {

        }
    }

    class Cliente {

        static final int DOCUMENTO_TIPO_ASCII = 0;

        static final int DOCUMENTO_TIPO_PDF = 1;

        private Documento ascii = new ASCII();

        private Documento pdf = new PDF();

        public Documento criarDocumento(int tipo) {

            if (tipo == Cliente.DOCUMENTO_TIPO_ASCII) {
                return ascii.clone();
            } else {
                return pdf.clone();
            }
        }
    }
    abstract class Aplicacao {

        protected MeuDocumento doc;

        abstract MeuDocumento criaDocumento();

        void novoDocumento() {
            this.doc = this.criaDocumento();
        }

        void abrirDocumento() {
            this.doc.abrir();
        }
    }

    abstract class Documento1 {

        void abrir() {
            System.out.println("Documento:Abrir documento!");
        }

        void fechar() {
            System.out.println("Documento:Fechar documento!");
        }

        void gravar() {
            System.out.println("Documento:Gravar documento!");
        }
    }

    class MinhaAplicacao extends Aplicacao {

        MeuDocumento criaDocumento() {
            return new MeuDocumento();
        }
    }

    class MeuDocumento extends Documento1 {

    }
}
