public class BinarySearchTree<T> {
    Node<T> root;

    // Metodos principais
    public void insert(Player player) {

    };
    //public bool search(String name)
    //public Player remove(String name)
    //private Node<T> insert(Node current, Player player){
    //
    //};
    //private Node search(Node current, String name)
    //private Node remove(Node current, String name)
    //public void inOrder() -> Opcional

    //Metodos auxiliares

    private static class Node<T> {
        Player player;
        Node<T> left;
        Node<T> right;

        public Node(Player player, Node<T> left, Node<T> right) {
            this.player = player;
            this.left = left;
            this.right = right;
        }
    }
}
