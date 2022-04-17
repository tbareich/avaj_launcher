/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Baloon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tbareich <tbareich@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/17 22:45:29 by tbareich          #+#    #+#             */
/*   Updated: 2022/04/17 22:45:30 by tbareich         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package factory;

import factory.interfaces.Flyable;
import tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateConditions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		// TODO Auto-generated method stub

	}

}
