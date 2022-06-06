package Cache;

public interface Cache {
    //Метод для обновления кэша через мутацию
    void bulkUpdate(Updater updater);

    //Метод, который принимает индексы для чтения
    long[] bulkRead(int[] indices);
}
