/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tbareich <tbareich@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/17 22:45:32 by tbareich          #+#    #+#             */
/*   Updated: 2022/04/17 22:55:16 by tbareich         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package factory;

import exceptions.UnkonwnAircraftTypeException;
import factory.interfaces.Flyable;

public abstract class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude,
			int latitude, int height)
			throws UnkonwnAircraftTypeException {
		if (type == "Baloon")
			return new Baloon(name, new Coordinates(longitude, latitude,
					height));
		else if (type == "JetPlane")
			return new JetPlane(name, new Coordinates(longitude, latitude,
					height));
		else if (type == "Helicopter")
			return new Helicopter(name, new Coordinates(longitude, latitude,
					height));
		throw new UnkonwnAircraftTypeException();
	}
}
