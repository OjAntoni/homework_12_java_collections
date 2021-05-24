/**
 * Кастомная имплементация динамического массива, использующая generics
 * @param <G> тип класса, который будет храниться в динамическом массиве
 * Реализация структуры данных позволяет использовать отрицательный индексы
 * и любое целочисленное число в качестве индекса.
 * Если индекс отрицательный - ведеться отсчет с конца заполненного массива
 * Если индекс по модулю превосходит длинну заполненного массива,
 * то отсчет индекс по достижению конца заполненного массива (в случае с отрицательным
 * значением индекса - начала) возвращается в начало (конец) заполненного массива
 * и продолжает отсчет.
 * При нехватке места в массиве, он расширяется вдвое.
 */
public class DArray<G>{

    //массив для хранения объектов
    private G[] array;
    //актуальная длинна заполненного массива
    private int length;
    //по умолчанию создаётся массив 16 элементов
    public DArray(){
        array = (G[])new Object[16];
    }

    /**
     * Конструктор массива с первоночальной длинной length
     * @param length длинна первоночального массива
     * @throws IllegalArgumentException если длинна массива отрицательна
     */
    public DArray(int length) throws IllegalArgumentException{
        if(length<0) throw new IllegalArgumentException();
        array = (G[]) new Object[length];
    }

    /**
     * Добавляет элемент в конец массива
     * @param elem элемент для добавления
     */
    public void add(G elem){
        if(length==array.length-1) doublesize();
        array[length] = elem;
        length++;
    }

    /**
     * Добавляет элемент в заданную пользователем позицию
     * @param elem - элемент для добавления
     * @param pos - позиция для вставки нового элемента
     */
    public void add(G elem, int pos){
        if(length == array.length) doublesize();
        System.arraycopy(array, formatIndex(pos), array, formatIndex(pos)+1, length-formatIndex(pos));
        array[formatIndex(pos)]=elem;
        length++;
    }

    /**
     * Удаляет последний элемент в массиве
     */
    public void delete(){
        delete(length-1);
    }

    /**
     * Удаляет элемент в массиве под индексов pos
     * @param pos - индекс элемента в массиве для удаления
     */
    public void delete(int pos){
        //if(pos>length||pos<0) throw new IndexOutOfBoundsException();
        System.arraycopy(array,formatIndex(pos)+1, array, formatIndex(pos), length-formatIndex(pos));
        length--;
    }

    /**
     * Удаляет первое вхождение элемента в массиве.
     * Используется метод equals()
     * @param elem - элемент для удаления
     */
    public void delete(G elem){
        for(int i = 0; i < length; i++){
            if(elem.equals(array[i])){
                System.arraycopy(array,i+1, array, i, length-i);
                length--;
                return;
            }
        }
    }

    /**
     * Возвращает индекс элемента в массиве.
     * Если таких элементов несколько, аозвращает индекс первого из них
     * @param elem элемент, индекс которого нужно получить
     * @return индекс элемента, если такой существует; -1 если такого элемента нету
     */
    public int getIndexOf(G elem) {
        for (int i = 0; i < length; i++) {
            if (elem.equals(array[i]))
                return i;
        }
        return -1;
    }

    /**
     * Возвращает обьект по индексу
     * @param index - индекс элемента в массиве для получения
     * @return обьект по индексу index
     */
    public G getValue(int index){
        return array[formatIndex(index)];
    }

    /**
     * Проверяет есть ли элемент в массиве
     * @param elem элемент для поиска в массиве
     * @return true, если есть; false, если нету
     */
    public boolean contains(G elem){
        return getIndexOf(elem)>=0;
    }

    /**
     * Возвращает длинну заполненного массива
     * @return длинну заполненного массива
     */
    public int getLength(){
        return length;
    }

    private void doublesize(){
        G[] newArray = (G[])new Object[length*2];
        System.arraycopy(array,0,newArray,0,length);
        array = newArray;
    }

    private int formatIndex(int i){
        if(i>length) return i%length;
        if(i<0){
            if(Math.abs(i)>length) return length-Math.abs(i)%length;
            else return length+i;
        }
        return i;
    }
}
