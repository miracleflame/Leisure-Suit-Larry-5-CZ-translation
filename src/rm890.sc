;;; Sierra Script 1.0 - (do not remove this comment)
(script# 890)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Patti)
(use Osc)
(use RandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use Rev)
(use Sound)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm890 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)
(instance rm890 of LLRoom
	(properties
		lookStr {Nacházíš se v øídicí místnosti B rádia K-RAP. Na to, jak je to velká místnost, vypadala zvenèí rozhodnì menší. Stìny jsou zaplnìny nesèetným množstvím nahrávacích zaøízení, elektronických pøístrojù, mixážních pultù, mikrofonù, nahrávacích pásek atd. atd.}
		picture 890
		south 880
	)
	
	(method (init)
		(proc958_0 128 872 880 882 883 890 891)
		(proc958_0 132 891 146 800 801 802)
		(proc958_0 130 969)
		(proc0_3)
		(proc0_13 0)
		(gLarry
			init:
			actions: ActionsKRAP
			normalize: 872
			x: 70
			y: 185
		)
		(super init:)
		(fElectronics1 init: approachVerbs: 3 4 2)
		(fElectronics2 init: approachVerbs: 3 4 2)
		(fElectronics3 init: approachVerbs: 3 4 2)
		(fElectronics4 init: approachVerbs: 3 4 2)
		(fElectronics5 init: approachVerbs: 3 4 2)
		(fElectronics6 init:)
		(fElectronics7 init:)
		(speaker1 init:)
		(speaker2 init:)
		(speaker3 init:)
		(tapeShelf init: approachVerbs: 3 2)
		(shelf init: approachVerbs: 3 2)
		(recorder init: approachVerbs: 3 4 2)
		(tape init: approachVerbs: 3 4 2)
		(if (== ((Inv at: 12) owner?) 3)
			(tape setLoop: 0 x: 35 y: 142 stopUpd:)
		else
			(tape stopUpd:)
		)
		(mixer init: approachVerbs: 3 2)
		(microphone init: approachVerbs: 3 5 2)
		(glass init: stopUpd:)
		(lights init: approachVerbs: 3 2 stopUpd:)
		(if (proc0_6 154) (lights setCycle: Fwd startUpd:))
		(gAddToPics doit:)
		(recSignA init: setCycle: Fwd)
		(hammer_a init: setCycle: RandCycle cycleSpeed: 12)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						98
						189
						103
						187
						235
						187
						289
						166
						284
						154
						265
						161
						189
						133
						112
						133
						17
						176
						29
						189
						0
						189
					yourself:
				)
		)
	)
	
	(method (doit)
		(cond 
			(script (script doit:))
			((gLarry edgeHit?)
				(if local3
					(if (not local5) (proc0_14 890 0) (= local5 1))
				else
					(global2 newRoom: 880)
				)
			)
			(local5 (= local5 0))
			(else (super doit:))
		)
	)
	
	(method (dispose)
		(proc958_0 0 969)
		(super dispose:)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry hide:)
				(tape hide:)
				(glass hide:)
				(lights hide:)
				(recSignA dispose:)
				((global2 obstacles?) dispose:)
				(gIconBar disable:)
				(global2 drawPic: 880 picture: 880 curPic: 880)
				(gIconBar enable:)
				(doorA init: close:)
				(doorB init:)
				(mikestand init: stopUpd:)
				(recSign init: setCycle: Fwd)
				(gAddToPics doit:)
				(hammer_a
					setLoop: -1
					view: 882
					x: 65
					y: 86
					xStep: 8
					yStep: 4
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: Walk
					setMotion: MoveTo 156 123 self
				)
			)
			(1
				(proc0_14 890 1)
				(hammer_a
					view: 883
					xStep: 3
					yStep: 2
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 2
					setMotion: MoveTo 186 123 self
				)
				(mikestand startUpd: setMotion: MoveTo 205 123)
			)
			(2
				(= local3 1)
				(mikestand stopUpd:)
				(hammer_a
					setLoop: -1
					view: 882
					xStep: 8
					yStep: 4
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: Walk
					setMotion: MoveTo 30 124 self
				)
			)
			(3
				(proc0_14 890 2)
				(proc0_14 890 3)
				(hammer_a setMotion: MoveTo -30 124 self)
			)
			(4
				(doorA dispose:)
				(doorB dispose:)
				(mikestand dispose:)
				(hammer_a dispose:)
				(recSign dispose:)
				(gIconBar disable:)
				(global2
					drawPic: 890
					picture: 890
					curPic: 890
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								0
								319
								0
								319
								189
								98
								189
								103
								187
								235
								187
								289
								166
								284
								154
								265
								161
								189
								133
								112
								133
								17
								176
								29
								189
								0
								189
							yourself:
						)
				)
				(gIconBar enable:)
				(gLarry show:)
				(tape show:)
				(glass show: stopUpd:)
				(lights show:)
				(= seconds 3)
			)
			(5
				(proc0_14 890 4)
				(proc0_14 890 5)
				(proc0_14 890 6)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance fElectronics1 of Feature
	(properties
		x 150
		y 199
		nsTop 165
		nsLeft 117
		nsBottom 189
		nsRight 184
		description {obøí reproduktor}
		sightAngle 40
		approachX 151
		approachY 187
		lookStr {Pøísahala bys, že to jsou pravé reproduktory Altec "Hlas divadla". Tyhle krásky jsi nevidìla už léta!}
	)
)

(instance fElectronics2 of Feature
	(properties
		x 283
		y 187
		nsTop 163
		nsLeft 247
		nsBottom 189
		nsRight 319
		description {elektronické vybavení}
		sightAngle 40
		approachX 235
		approachY 187
		lookStr {Všude, kam se podíváš, vidíš tlaèítka, pøepínaèe, svìtla, cívky s páskami a páskové mechaniky.}
	)
)

(instance fElectronics3 of Feature
	(properties
		x 301
		y 169
		nsTop 129
		nsLeft 283
		nsBottom 163
		nsRight 319
		description {elektronické vybavení}
		sightAngle 40
		approachX 281
		approachY 169
		lookStr {Všude, kam se podíváš, vidíš tlaèítka, pøepínaèe, svìtla, cívky s páskami a páskové mechaniky.}
	)
)

(instance fElectronics4 of Feature
	(properties
		x 277
		y 151
		nsTop 106
		nsLeft 235
		nsBottom 135
		nsRight 319
		description {levý velký bubnový magnetofon}
		sightAngle 40
		approachX 237
		approachY 151
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 890 7))
			(2 (proc0_14 890 8))
			(4
				(switch param2
					(12 (proc0_14 890 9))
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance fElectronics5 of Feature
	(properties
		x 215
		y 139
		nsTop 106
		nsLeft 196
		nsBottom 125
		nsRight 235
		description {pravý velký bubnový magnetofon}
		sightAngle 40
		approachX 205
		approachY 139
	)
	
	(method (doVerb theVerb param2)
		(fElectronics4 doVerb: theVerb param2 &rest)
	)
)

(instance fElectronics6 of Feature
	(properties
		x 265
		y 63
		nsTop 17
		nsLeft 274
		nsBottom 109
		nsRight 319
		description {elektronické zaøízení}
		sightAngle 40
		lookStr {Všude, kam se podíváš, vidíš tlaèítka, pøepínaèe, svìtla, cívky s páskou a páskové mechaniky. Bohužel jsou pøíliš vysoko než abys na nì dosáhla.}
	)
)

(instance fElectronics7 of Feature
	(properties
		x 265
		y 63
		nsTop 30
		nsLeft 212
		nsBottom 109
		nsRight 274
		description {elektronické zaøízení}
		sightAngle 40
		lookStr {Všude, kam se podíváš, vidíš tlaèítka, pøepínaèe, svìtla, cívky s páskami a páskové mechaniky. Bohužel jsou pøíliš vysoko, než abys na nì dosáhla.}
	)
)

(instance speaker1 of Feature
	(properties
		x 100
		y 60
		nsTop 43
		nsLeft 86
		nsBottom 78
		nsRight 114
		description {reproduktor monitoru}
		sightAngle 40
		lookStr {Pøísahala bys, že to jsou pravé reproduktory Altec "Hlas divadla". Tyhle krásky jsi nevidìla už léta!}
	)
)

(instance speaker2 of Feature
	(properties
		x 199
		y 57
		nsTop 42
		nsLeft 186
		nsBottom 72
		nsRight 212
		description {reproduktor monitoru}
		sightAngle 40
		lookStr {Pøísahala bys, že to jsou pravé reproduktory Altec "Hlas divadla". Tyhle krásky jsi nevidìla už léta!}
	)
)

(instance speaker3 of Feature
	(properties
		x 10
		y 24
		nsBottom 49
		nsRight 21
		description {reproduktor monitoru}
		sightAngle 40
		lookStr {Pøísahala bys, že to jsou pravé reproduktory Altec "Hlas divadla". Tyhle krásky jsi nevidìla už léta!}
	)
)

(instance shelf of Feature
	(properties
		x 154
		y 87
		nsTop 63
		nsLeft 120
		nsBottom 131
		nsRight 189
		description {stojan s vybavením}
		sightAngle 40
		approachX 155
		approachY 139
		lookStr {Tento regál obsahuje spoustu elektronického vybavení, vìtšinou starého, a také polici plnou prázdných kotouèových kazet.}
	)
)

(instance tapeShelf of Feature
	(properties
		x 154
		y 87
		nsTop 79
		nsLeft 138
		nsBottom 102
		nsRight 169
		description {polièka s kazetami}
		sightAngle 40
		approachX 155
		approachY 139
		lookStr {Aha, tady je to, co potøebuješ! Polièka plná prázdných cívkových nahrávacích pásek.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (!= ((Inv at: 12) owner?) 0)
					(proc0_14 890 10)
				else
					(gLarry setScript: GetTape)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance mixer of Feature
	(properties
		x 70
		y 144
		nsTop 107
		nsLeft 66
		nsBottom 126
		nsRight 104
		description {mikrofonní mixér}
		sightAngle 40
		approachX 90
		approachY 140
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch (++ local6)
					(1 (proc0_14 890 11))
					(2 (proc0_14 890 12))
					(3 (proc0_14 890 13))
					(4 (proc0_14 890 14))
					(5 (proc0_14 890 15))
					(6 (proc0_14 890 16))
					(7 (proc0_14 890 17))
					(else  (proc0_14 890 18))
				)
			)
			(3
				(if (== (++ local7) 1)
					(proc0_14 890 19)
				else
					(gLarry setScript: useMixer)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance microphone of Feature
	(properties
		x 59
		y 145
		nsTop 102
		nsLeft 50
		nsBottom 120
		nsRight 68
		description {mikrofon}
		sightAngle 40
		approachX 89
		approachY 141
		lookStr {Profesionální, špièkový, studiový páskový mikrofon visí na rameni nad studiovým pultem.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 890 20))
			(5
				(if local3
					(if local8
						(gLarry setScript: useMikeScript)
					else
						(proc0_14 890 21)
					)
				else
					(proc0_14 890 22)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance recorder of Feature
	(properties
		x 26
		y 163
		nsTop 115
		nsBottom 146
		nsRight 52
		description {kotouèový magnetofon}
		approachX 42
		approachY 163
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(cond 
					(local1 (gLarry setScript: turnRecorderOff))
					((== ((Inv at: 12) owner?) 3)
						(cond 
							(local9 (gLarry setScript: getRecordedTape))
							(local2 (gLarry setScript: rewindTape))
							((proc0_6 154) (gLarry setScript: turnRecorderOn))
							(else (proc0_14 890 23))
						)
					)
					(else (proc0_14 890 24))
				)
			)
			(2
				(cond 
					(local1 (proc0_14 890 25))
					((== ((Inv at: 12) owner?) 3)
						(cond 
							(local9 (proc0_14 890 26))
							(local2 (proc0_14 890 27))
							(else (proc0_14 890 28))
						)
					)
					(else (proc0_14 890 29))
				)
			)
			(4
				(switch param2
					(12
						(if local2
							(proc0_14 890 30)
						else
							(gLarry setScript: mountTapeScript)
						)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tape of Prop
	(properties
		x 42
		y 130
		description {páska}
		approachX 42
		approachY 163
		lookStr {Velký konzolový magnetofon Studer je rozehøátý a pøipravený k nahrávání - až na to, že nemá pásku, na kterou by se dalo nahrávat!}
		view 890
		loop 1
	)
	
	(method (doVerb theVerb param2)
		(recorder doVerb: theVerb param2)
	)
)

(instance tapeHole of PicView
	(properties
		x 158
		y 85
		view 890
		loop 7
	)
	
	(method (doVerb theVerb param2)
		(tapeShelf doVerb: theVerb param2)
	)
)

(instance hammer_a of Actor
	(properties
		x 38
		y 120
		description {P. C. Hammer}
		lookStr {P. C. Hammer pracuje ve vedlejší øídící místnosti.}
		view 883
		loop 3
	)
)

(instance glass of Prop
	(properties
		x 41
		y 116
		description {sklenìné okno}
		lookStr {Tìžké, zvukotìsné okno z tabulového skla tì oddìluje od vnìjšího svìta - a tvé svobody! }
		view 890
		loop 2
		cel 1
		priority 9
		signal $0010
	)
)

(instance lights of Prop
	(properties
		x 53
		y 122
		description {mikrofonní mixér}
		approachX 90
		approachY 144
		view 890
		loop 3
		priority 9
		signal $0010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(mixer doVerb: theVerb param2 &rest)
			)
			(2
				(mixer doVerb: theVerb param2 &rest)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance recSignA of Prop
	(properties
		x 17
		y 51
		description {kontrolka nahrávání}
		lookStr {Tato kontrolka se rozsvítí vždy, když nìkdo nahrává v øídící místnosti A.}
		view 890
		loop 6
		cel 1
		cycleSpeed 12
	)
)

(instance useMikeSound of Sound
	(properties
		flags $0001
		number 891
	)
)

(instance breakGlassSound of Sound
	(properties
		number 146
		priority 11
	)
)

(instance useMikeScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: MoveTo 89 141 self)
			)
			(1
				(gLarry
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(useMikeSound play:)
				(gLarry setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(proc0_14 890 31)
				(glass startUpd: setCel: 2)
				(= ticks 123)
			)
			(4
				(breakGlassSound play:)
				(glass setCycle: End self)
			)
			(5 (= seconds 3))
			(6
				(proc0_14 890 32)
				(proc0_14 890 33)
				(= seconds 4)
			)
			(7
				(gLarry
					setLoop: 4
					setPri: 9
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(8
				(gLarry
					actions: 0
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(proc0_10 15 157)
				(= ticks 123)
			)
			(10
				(gLarry
					view: 891
					posn: 18 114
					actions: 0
					setCel: 0
					setLoop: 7
					setCycle: 0
				)
				(= ticks 123)
			)
			(11
				(gLarry setMotion: MoveTo 1 114 self)
			)
			(12 (= seconds 3))
			(13
				(gLongSong fade: 0 15 12 1)
				(gIconBar disable:)
				(DrawPic 1 -32762)
				(= ticks 30)
			)
			(14
				(gIconBar enable:)
				(proc0_14 890 34)
				(= seconds 3)
			)
			(15
				(proc0_14 890 35)
				(= seconds 3)
			)
			(16
				(= temp0 0)
				(while (< temp0 (Inv size?))
					(if ((= temp1 (Inv at: temp0)) ownedBy: 1000)
						(temp1 owner: 24)
					)
					(++ temp0)
				)
				(global2 newRoom: 200)
			)
		)
	)
)

(instance GetTape of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 891
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1 (= ticks 30))
			(2
				(tapeHole init:)
				(gAddToPics doit:)
				(gLarry setCel: 255 setCycle: Beg self)
			)
			(3
				(gLarry get: 12 normalize: 872 setHeading: 0)
				(= ticks 30)
			)
			(4
				(proc0_10 4 158)
				(proc0_14 890 36)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance turnRecorderOn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(tape setCycle: Rev startUpd:)
				(gLarry normalize: 872 loop: 4 cel: 1 setHeading: 270)
				(= ticks 30)
			)
			(2
				(proc0_10 4 155)
				(proc0_14 890 37)
				(= local1 1)
				(= seconds 7)
			)
			(3
				(proc0_14 890 38)
				(= seconds 3)
			)
			(4
				(hammer_a setLoop: 1 setCycle: End self)
			)
			(5
				(proc0_14 890 39)
				(= seconds 3)
			)
			(6
				(hammer_a
					cel: 0
					setCycle: 0
					setMotion: MoveTo 10 120 self
				)
			)
			(7
				(proc0_14 890 40)
				(glass startUpd:)
				(= cycles 5)
			)
			(8
				(self dispose:)
				(global2 setScript: sCartoon)
			)
		)
	)
)

(instance turnRecorderOff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(tape setCycle: 0 stopUpd:)
				(= ticks 30)
			)
			(2
				(= local1 0)
				(= local2 1)
				(gLarry normalize: 872 loop: 4 cel: 1 setHeading: 270)
				(= ticks 30)
			)
			(3
				(proc0_14 890 41)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance rewindTape of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 891
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1 (= ticks 30))
			(2
				(gLarry normalize: 872 loop: 4 cel: 1 setHeading: 270)
				(tape setCycle: Fwd startUpd: cycleSpeed: 0)
				(= seconds 7)
			)
			(3
				(tape setCycle: 0 stopUpd:)
				(= ticks 30)
			)
			(4
				(proc0_14 890 42)
				(= local9 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance getRecordedTape of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 891
					setLoop: 1
					setCel: 3
					cycleSpeed: 12
					setCycle: CT 2 -1 self
				)
			)
			(1
				(tape setLoop: 1 setCel: 0 x: 42 y: 130 stopUpd:)
				(gLarry cycleSpeed: 12 setCycle: Beg self)
			)
			(2
				(gLarry get: 12)
				((Inv at: 12) state: 1)
				(gLarry normalize: 872 loop: 4 cel: 1 setHeading: 270)
				(= ticks 30)
			)
			(3
				(proc0_10 7 156)
				(proc0_14 890 43)
				(= ticks 30)
			)
			(4 (proc0_3) (self dispose:))
		)
	)
)

(instance useMixer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 891
					setLoop: 2
					cycleSpeed: 12
					setCel: 0
					setCycle: Osc 1 self
				)
			)
			(1
				(gLarry loop: 4 cel: 1 setHeading: 270 normalize: 872)
				(= ticks 30)
			)
			(2
				(switch local7
					(1)
					(2
						(proc0_14 890 44)
						(Wait 60)
						(proc0_14 890 45)
					)
					(3
						(proc0_14 890 46)
						(Wait 60)
						(proc0_14 890 47)
					)
					(4
						(proc0_14 890 48)
						(Wait 60)
						(proc0_14 890 49 67 -1 185)
					)
					(5
						(proc0_14 890 50)
						(Wait 60)
						(proc0_14 890 51)
					)
					(6
						(proc0_14 890 52)
						(Wait 60)
						(proc0_14 890 53)
					)
					(else 
						(cond 
							((not (proc0_6 154)) (gLarry setScript: sHearingScrew))
							(local3
								(if local8
									(proc0_14 890 54)
								else
									(proc0_14 890 55)
									(= local8 1)
								)
							)
							(else (proc0_14 890 56))
						)
					)
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sHearingScrew of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_14 890 57)
				(lights setCycle: Fwd startUpd:)
				(= seconds 3)
			)
			(1
				(proc0_14 890 58)
				(= seconds 3)
			)
			(2
				(proc0_10 8 154)
				(proc0_14 890 59)
				(= local4 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance mountTapeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(Patti put: 12 3)
				(gLarry
					view: 891
					setLoop: 1
					cycleSpeed: 12
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(tape setLoop: 0 x: 35 y: 142)
				(gLarry setCycle: End self)
			)
			(2
				(gLarry normalize: 872 loop: 4 cel: 1 setHeading: 270)
				(= ticks 30)
			)
			(3
				(proc0_14 890 60)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance doorA of Door
	(properties
		x 47
		y 77
		description {dveøe øídicí místnosti A}
		sightAngle 40
		approachX 64
		approachY 80
		lookStr {Buï opatrná, Patti! Uvnitø tìchto dveøí stojí muž, kterého jsi sem pøišla vyšetøovat: P. C. Hammer!}
		view 880
		loop 1
		signal $4000
		locked 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 890 61))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance doorB of Door
	(properties
		x 199
		y 111
		description {dveøe øídící místnosti B}
		sightAngle 40
		approachX 218
		approachY 116
		lookStr {Na dveøích je nápis "Øídící místnost B". V souèasné dobì je neobsazená.}
		view 880
		loop 2
		entranceTo 890
		locked 1
		moveToX 220
		moveToY 116
		enterType 0
		exitType 0
	)
)

(instance hammer_b of Actor
	(properties
		x 82
		y 79
		description {P. C. Hammer}
		lookStr {Pøes okno øídicí místnosti vidíš P. C. Hammera, jak míchá své "živé" rozhlasové vysílání pro zítøejší ranní show.}
		view 883
	)
)

(instance mikestand of Actor
	(properties
		x 175
		y 121
		description {stojan na mikrofon}
		lookStr {Velký mikrofonní stojan s ramenem stojí hned za dveømi do øídicí místnosti B.}
		view 880
		signal $4000
	)
)

(instance recSign of Prop
	(properties
		x 177
		y 42
		description {kontrolka nahrávání}
		lookStr {Tato kontrolka se rozsvítí, kdykoli nìkdo nahrává v této øídicí místnosti.}
		view 880
		loop 3
		cel 1
		cycleSpeed 12
	)
)

(instance ActionsKRAP of Actions
	(properties)
	
	(method (doit)
		(return 0)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(3 (proc0_14 890 62) (return 1))
				(10
					(proc0_14 890 63)
					(return 1)
				)
				(else  (return 0))
			)
		)
	)
)
