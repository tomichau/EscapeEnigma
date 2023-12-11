class Tes extends Program{
    void algorithm(){
        println(Filetxt("logo2.txt"));
    }
    String Filetxt(String file){
        String result = "";
        for(int i = 0; i < rowCount(loadCSV(file)); i++){
            result = result + getCell(loadCSV(file), i, 0) + "\n";
        }
        return result;
    }
}