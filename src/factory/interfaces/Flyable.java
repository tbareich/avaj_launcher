/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Flyable.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tbareich <tbareich@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/17 22:55:35 by tbareich          #+#    #+#             */
/*   Updated: 2022/04/17 22:55:36 by tbareich         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package factory.interfaces;

import tower.WeatherTower;

public interface Flyable {
	public void updateConditions();

	public void registerTower(WeatherTower WeatherTower);
}
