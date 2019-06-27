for(int x=llimit; x<ulimit; ++x){
      for(int y=0; y<nCells ; ++y){
        if(cells[x][y][p]==1){
          double rr = rd.nextDouble();
          if(rr<Ps){ //Survive?
            int PH=0; boolean proliferate=true;
            double rpo = rd.nextDouble();
            double[] P = probabilities(x, y);
            int i=x, j=y;
            if(0<=rpo && rpo<=P[0] ){ i=x-1; j=y;}else{
              if(P[0]<rpo && rpo<=P[0]+P[1]){ i=x+1; j=y;}else{
                if(P[0]+P[1]<rpo && rpo<=P[0]+P[1]+P[2]){ i=x; j=y-1;}else{
                  if(P[0]+P[1]+P[2]<rpo && rpo<=1){ i=x; j=y+1;}
                }
              }
            }
            while(PH!=NP && proliferate){
              double rrp = rd.nextDouble();
              if(rrp>=Pp){ //Proliferate?
                proliferate=false;
                double rrm = rd.nextDouble();
                if(rrm<Pm){ //Migrate?
                  cells[x][y][q]=0;
                  if(i>=0&&nCells>i&&j>=0&&nCells>j){ cells[i][j][q]=1;}
                  else{ cells[x][y][q]=1;}
                }else{ cells[x][y][q]=1;}
              }else{PH++;}
            }
            if(proliferate){
              cells[x][y][q]=1;
              if(i<0||nCells-1<i||j<0||nCells-1<j){}
              else{ cells[i][j][q]=1;}
            }
          }else{cells[x][y][q]=0;}
        }
        cellsP[x][y]=cells[x][y][q];
      }
    }
    try{
      br.await();
    }catch(Exception e){}
  }
