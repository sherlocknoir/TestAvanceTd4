// Based on a B specification from Marie-Laure Potet.

//@ nullable_by_default
public class Explosives{
    public int nb_inc = 0;
    public String [][] incomp = new String[50][2];
    public int nb_assign = 0;
    public String [][] assign = new String[30][2];
    
 
    /*@ public invariant // Prop 1
      @ (0 <= nb_inc && nb_inc < 50);
      @*/
    /**
     * le variable incomp est un tableau 2 dimentions [50][2], 
     * donc le nombre de incompatibles au paires et il ne peut pas dépasser à 50
     * il faut contraindre nb_inc entre 0 et 50
     */
    
    /*@ public invariant // Prop 2
      @ (0 <= nb_assign && nb_assign < 30);
      @*/
    /**
     * le variable assign est un tableau 2 dimentions [30][2], 
     * donc le nombre de assign au paires et il ne peut pas dépasser à 30
     * il faut contraindre nb_assign entre 0 et 30
     */

    /*@ public invariant // Prop 3
      @ (\forall int i; 0 <= i && i < nb_inc; 
      @         incomp[i][0].startsWith("Prod") && incomp[i][1].startsWith("Prod"));
      @*/
    /**
     * Tous les elements au paires dans le tableau incomp, 
     * il faut commencer par "Prod" 
     * Comme ca on peut assurer ce qu'on compare les choses de meme type.
     */
    /*@ public invariant // Prop 4
      @ (\forall int i; 0 <= i && i < nb_assign; 
      @         assign[i][0].startsWith("Bat") && assign[i][1].startsWith("Prod"));
      @*/
    /**
     * pour les elements au paires dans le tableau assign,
     * il faut verifier que tous sont bien typées comme dessus:
     * le premier varible dans assign[] est un batiment, alors il faut commencer par "Bat"
     * Deuxeme varible dans assign[] est un produit, alors il faut commencer par "Prod"
     */
    /*@ public invariant // Prop 5
      @ (\forall int i; 0 <= i && i < nb_inc; !(incomp[i][0]).equals(incomp[i][1]));
      @*/
    /**
     * Il faut verifier que chaque paire d'éléments inserees sont différents dans le tableau incomp.
     * CTD on ne peut pas avoir un produit qui est incompatible avec soi-même.
     */
    /*@ public invariant // Prop 6
      @ (\forall int i; 0 <= i && i < nb_inc; 
      @        (\exists int j; 0 <= j && j < nb_inc; 
      @           (incomp[i][0]).equals(incomp[j][1]) 
      @              && (incomp[j][0]).equals(incomp[i][1]))); 
      @*/
    /**
     * Pour chaque i contraint entre 0 et nb_inc,
     * il existe un j qui satisfait (incomp[i][0]).equals(incomp[j][1]) &&(incomp[j][0]).equals(incomp[i][1])))
     * CTD, pour chaque couple de variables dans le tableau incomp,
     * les deux instances de ce couple, ils ont d'ordre.
     * s'il existe un couple (A ,  B), il faut verifier qu'il exite le couple à l'inverse(B, A)
     */
    /*@ public invariant // Prop 7
      @ (\forall int i; 0 <= i &&  i < nb_assign; 
      @     (\forall int j; 0 <= j && j < nb_assign; 
      @        (i != j && (assign[i][0]).equals(assign [j][0])) ==>
      @        (\forall int k; 0 <= k && k < nb_inc;
      @           (!(assign[i][1]).equals(incomp[k][0])) 
      @              || (!(assign[j][1]).equals(incomp[k][1])))));
      @*/
    /**
     * A ==> B est equal avec !A||B, 
	 * si A implies B est vrai, CTD, si A est vrai, alors B est obligatoirement vrai;
	 * 								 sinon A est faux, on ne vérifie pas B.
     * donc pour ce cas là, soit les produits ne sont pas dans le meme batiment, 
	 * soit si ils déposent dans le meme endroit, ils doivent etre compatible
     * 
     * Cette invariant est pour assurer qu'il n'y pas des produits incompatibles qui sont déposés dans le meme batiment.
     */

	

	/*@requires prod1 != null;
 	  @requires prod2 != null;
  	  @requires nb_inc < 48;
	  @requires !prod1.equals(prod2);
	  @requires prod1.startsWith("Prod") && prod2.startsWith("Prod");
	  @*/
    
    public void add_incomp(String prod1, String prod2){
		incomp[nb_inc][0] = prod1;
		incomp[nb_inc][1] = prod2;
		incomp[nb_inc+1][1] = prod1;
		incomp[nb_inc+1][0] = prod2;
		nb_inc = nb_inc+2;
     }

	/*@requires bat != null;
	  @requires prod != null;
	  @requires nb_assign < 29;
	  @requires bat.startsWith("Bat") && prod.startsWith("Prod");
	  @requires 
	  @		(\forall int i; 0 <= i && i < nb_assign;
	  @			(assign[i][0].equals(bat)) ==> 
	  @			!(\exists int j; 0 <= j && j < nb_inc; 
	  @				(assign[i][1].equals(incomp[j][0]) && incomp[j][1].equals(prod))));
	  @*/
    public void add_assign(String bat, String prod){
		assign[nb_assign][0] = bat;
		assign[nb_assign][1] = prod;
		nb_assign = nb_assign+1;
    }


// 1ere moyenne 
	//@requires prod != null;
	//@requires prod.startsWith("Prod");
	/*@requires //specifier en JML
	  @(\exists int i; 0<=i && i<nb_assign;
	  @		(\forall int j; 0<=j && j<nb_assign;
	  @			(assign[i][0].equals(assign[j][0]) ==> 
	  @				(compatible(assign[j][1], prod)))));	
	  @*/
	public /*@ pure @*/ String findBat1(String prod){
		boolean trueFlag = false;
		for(int i = 0; i < nb_assign; i++){
			for(int k = 0; k < nb_assign; k++){
				if(!assign[i][0].equals(assign[k][0]))
					continue;
				if(!compatible(assign[k][1], prod)){
					trueFlag = false;
					break;
				}
				else
					trueFlag = true;
			}
		if(trueFlag == true)
			return assign[i][0];
		}
		return null;
	}	


// 2eme moyenne
	   public /*@ pure @*/ String findBat2(String prod) {
         /* code -2 means not compatable.
            -1 means compatible but product isnt already in the building.
            >=0 is the index of the building where the product is already found.
            */

        //un map qui contient notre list de batiment availible.
        HashMap batList = new HashMap();

        for (int i = 0; i < nb_assign; i++) {
            String bat = assign[i][0];
            String product = assign[i][1];
           // System.out.println("loop index : "+i+" batname: "+bat+" prod inside: "+product);

            if (batList.containsKey(bat)) { //our map already contains the building  we only
            // change the marker of a building if it becomes incompatible or to mark it as
            // already containing the product.

                if (!compatible(prod, product)) {
                   //mark the building as incompatible
                    batList.put(bat, Integer.valueOf(-2));
                }
                else if (((Integer)batList.get(bat)).intValue() ==-1 && prod.equals(product))
                {
                    //mark the building already containing the prod.
                    batList.put(bat, Integer.valueOf(i));

                }

            }
            else {  //building doesnt exist added and set intial building marker code.
                System.out.println("bulding doesnt exsit adding it to the map");
                if (compatible(prod, product)) {
                    if (prod.equals(product)) {
                        //add the batiment to the array with index of building containing
                        // the prod already
                        batList.put(bat, Integer.valueOf(i));
                        System.out.println(" added at index " + i);
                    } else {
                        //add the name of the building with a marker that it is compatible for
                        // the product.
                        batList.put(bat, Integer.valueOf(-1));
                        System.out.println("compatible but isnt the same");
                    }
                }
                else {
                    //add building with marker that the building is not compatable
                    System.out.println("not comp new building gets a -2");
                    batList.put(bat, Integer.valueOf(-2));
                }
            }
        }


        String bestBuildingMatch= null; //compatible and has the product
        String secondBuildingMatch= null; //compatible but doesnt have the product

        System.out.println("new map size "+batList.size());
        //find the best matching building
        for (Iterator it = batList.entrySet().iterator(); it.hasNext();) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(pairs.getKey() + " = " + (Integer)pairs.getValue());
            int comp = ((Integer) pairs.getValue()).intValue();
            String name = pairs.getKey().toString();
            if(comp >=0){
                bestBuildingMatch = name;
            }
            else if(comp == -1){
                secondBuildingMatch = name;
            }
        }
        //return the best matching building
        System.out.println("batlist? "+batList.values());
        if(bestBuildingMatch !=null){
            return bestBuildingMatch;
        }
        else if (secondBuildingMatch !=null){
            return secondBuildingMatch;
        }
        else{   //no compatible building found so we create a new one
            int count = 0;
            while(true) { //loop until we find a name that doesnt exsist.
                String name = "Bat_" + count;
                if (! batList.containsKey(name)) {
                    return name;
                } else {
                    count++;
                }
            }

        }

    }

	
	//@requires !prod1.equals(prod2);
	//@requires prod1 != null;
	//@requires prod2 != null;
	/*@ ensures \result == true <==> 
	  @			(\forall int i; 0<=i && i<nb_inc; !(incomp[i][0].equals(prod1) && incomp[i][1].equals(prod2)));
	  @*/

	public /*@ pure @*/ boolean compatible(String prod1, String prod2){
		for( int i = 0; i < nb_inc; i++){
			if(incomp[i][0].equals(prod1) && incomp[i][1].equals(prod2)){
				return false;
			}
		}
		return true;
	}

    public void skip(){
    }

    
}
